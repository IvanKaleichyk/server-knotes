package com.kaleichyk.plugins

import com.kaleichyk.exceptions.AlreadyExistsException
import com.kaleichyk.exceptions.AuthException
import com.kaleichyk.exceptions.CannotFindException
import com.kaleichyk.utils.exception.UserNotExist
import com.kaleichyk.utils.exception.WrongDataException
import com.kaleichyk.verifier.ValidateException
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
        exception<AlreadyExistsException> { cause ->
            call.respond(HttpStatusCode.Conflict, cause.message.orEmpty())
        }
        configureAuth()
        configureUser()
    }
}

private fun StatusPages.Configuration.configureAuth() {
    exception<AuthException> { cause ->
        call.respond(HttpStatusCode.Unauthorized, cause.message.orEmpty())
    }

    exception<UserNotExist> { cause ->
        call.respond(HttpStatusCode.NotFound, cause.message.orEmpty())
    }
}

private fun StatusPages.Configuration.configureUser() {
    exception<UserNotExist> { cause ->
        call.respond(HttpStatusCode.NotFound, cause.message.orEmpty())
    }

    exception<WrongDataException> { cause ->
        call.respond(HttpStatusCode.BadRequest, cause.message.orEmpty())
    }

    exception<ValidateException> { cause ->
        call.respond(HttpStatusCode.NotAcceptable, cause.message)
    }
}
