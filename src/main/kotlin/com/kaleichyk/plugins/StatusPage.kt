package com.kaleichyk.plugins

import com.kaleichyk.exceptions.CannotFindException
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

fun Application.configureStatusPage() {
    install(StatusPages) {
        exception<CannotFindException> { cause ->
            call.respond(HttpStatusCode.BadRequest, cause.message.orEmpty())
        }
    }
}
