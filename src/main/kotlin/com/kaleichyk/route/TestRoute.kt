package com.kaleichyk.route

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.configureTestRoute() {
    route("test") {
        get {
            call.respondText("Hello World")
        }
    }
}
