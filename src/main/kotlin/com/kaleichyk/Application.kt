package com.kaleichyk

import com.kaleichyk.plugins.configureDI
import com.kaleichyk.plugins.configureHTTP
import com.kaleichyk.plugins.configureMonitoring
import com.kaleichyk.plugins.configureSecurity
import com.kaleichyk.plugins.configureSerialization
import com.kaleichyk.route.configureTestRoute
import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) = EngineMain.main(args)

@Suppress("UNUSED")
fun Application.module() {
    configureDI()
    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureSerialization()

    routing {
        configureTestRoute()
    }
}
