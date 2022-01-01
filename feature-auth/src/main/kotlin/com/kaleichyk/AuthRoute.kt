package com.kaleichyk

import com.auth0.jwt.interfaces.JWTVerifier
import com.kaleichyk.controller.AuthController
import com.kaleichyk.exceptions.AuthException
import com.kaleichyk.interactor.AuthInteractor
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.utils.extentension.getLogin
import com.kaleichyk.utils.extentension.getPassword
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.jwt.JWTCredential
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Application.configureSecurity(interactor: AuthInteractor, verifier: JWTVerifier, realm: String) {

    install(Authentication) {
        jwt {
            this.realm = realm
            verifier(verifier)
            validate { credential ->
                validateCredential(interactor, credential)
            }
        }
    }

//    TODO("INSTALL ROLES FEATURE")
}

fun Route.createAuthRoute(controller: AuthController) {

    route("auth") {
        post("login") { body: LoginBody ->
            val response = controller.login(body)
            call.respond(response)
        }
        post("sign_up") { body: UserDetailsBody ->
            val response = controller.createAccount(body)
            call.respond(response)
        }
        post("refresh_token") { refreshToken: String ->
            val response = controller.refreshToken(refreshToken)
            call.respond(response)
        }
    }
}

private suspend fun validateCredential(interactor: AuthInteractor, credential: JWTCredential): JWTPrincipal {
    credential.payload.run {
        val result = interactor.validateCredential(getLogin(), getPassword())
        if (result) return JWTPrincipal(credential.payload)
        else throw AuthException("Not available JWT token")
    }
}
