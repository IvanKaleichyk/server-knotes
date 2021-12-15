package com.kaleichyk.plugins

import io.ktor.application.Application

fun Application.configureSecurity() {

//    authentication {
//        jwt {
//            val jwtAudience = environment.config.property("jwt.audience").getString()
//            realm = environment.config.property("jwt.realm").getString()
//            verifier(
//                JWT
//                    .require(Algorithm.HMAC256("secret"))
//                    .withAudience(jwtAudience)
//                    .withIssuer(environment.config.property("jwt.domain").getString())
//                    .build()
//            )
//            validate { credential ->
//                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
//            }
//        }
//    }

}
