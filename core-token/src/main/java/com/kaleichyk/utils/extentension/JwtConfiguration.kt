package com.kaleichyk.utils.extentension

import com.auth0.jwt.algorithms.Algorithm
import com.kaleichyk.longProperty
import com.kaleichyk.stringProperty
import io.ktor.application.Application

val Application.algorithm: Algorithm get() = Algorithm.HMAC512(environment.config.stringProperty(SECRET_WORD_PATH))

val Application.issuer get() = environment.config.stringProperty(ISSUER_PATH)

val Application.subject get() = environment.config.stringProperty(SUBJECT_PATH)

val Application.realm get() = environment.config.stringProperty(REALM_PATH)

val Application.tokenValidTime get() = environment.config.longProperty(EXPIRATION_TIME_PATH)

private const val SECRET_WORD_PATH = "jwt.secret"
private const val ISSUER_PATH = "jwt.issuer"
private const val SUBJECT_PATH = "jwt.subject"
private const val REALM_PATH = "jwt.realm"
private const val EXPIRATION_TIME_PATH = "jwt.expiration_time"
