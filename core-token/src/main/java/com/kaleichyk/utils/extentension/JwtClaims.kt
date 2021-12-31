package com.kaleichyk.utils.extentension

import com.auth0.jwt.interfaces.Payload
import com.kaleichyk.exceptions.AuthException
import com.kaleichyk.repository.TokenRepositoryImpl.Companion.LOGIN_CLAIM
import com.kaleichyk.repository.TokenRepositoryImpl.Companion.PASSWORD_CLAIM
import com.kaleichyk.repository.TokenRepositoryImpl.Companion.ROLES_CLAIM

fun Payload.getLogin() = getClaim(LOGIN_CLAIM).asString() ?: throw AuthException()

fun Payload.getPassword() = getClaim(PASSWORD_CLAIM).asString() ?: throw AuthException()

fun Payload.getRoles(): List<String> = getClaim(ROLES_CLAIM)?.asList(String::class.java) ?: throw AuthException()
