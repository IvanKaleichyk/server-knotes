package com.kaleichyk

import com.kaleichyk.plugins.configureHTTP
import com.kaleichyk.plugins.configureMonitoring
import com.kaleichyk.plugins.configureSecurity
import com.kaleichyk.plugins.configureSerialization
import com.kaleichyk.route.configureTestRoute
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureSerialization()

        routing {
            configureTestRoute()
        }
    }.start(wait = true)
}
