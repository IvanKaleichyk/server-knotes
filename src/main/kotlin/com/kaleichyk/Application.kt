package com.kaleichyk

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.kaleichyk.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
        configureSockets()
    }.start(wait = true)
}
