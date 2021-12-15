package com.kaleichyk.plugins

import com.kaleichyk.utils.header.Header
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.metrics.micrometer.MicrometerMetrics
import io.ktor.request.httpMethod
import io.ktor.request.path
import io.ktor.request.uri
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.slf4j.event.Level

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.DEBUG
        filter { call ->
            call.request.path().startsWith("/")
        }
        format { call ->
            call.request.run {
                val status = call.response.status()
                val httpMethod = httpMethod.value
                val userAgent = headers["User-Agent"]
                val platform = headers[Header.PLATFORM]
                val uri = uri
                "$uri \nStatus: $status, Platform: $platform, HTTP method: $httpMethod, User agent: $userAgent"
            }
        }
    }

    val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

    install(MicrometerMetrics) {
        registry = appMicrometerRegistry
    }

    routing {
        get("/metrics-micrometer") {
            call.respond(appMicrometerRegistry.scrape())
        }
    }
}
