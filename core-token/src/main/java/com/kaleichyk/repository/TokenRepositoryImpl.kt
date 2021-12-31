package com.kaleichyk.repository

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTCreator
import com.auth0.jwt.algorithms.Algorithm
import com.kaleichyk.utils.Token
import java.util.*

class TokenRepositoryImpl(
    private val algorithm: Algorithm,
    private val subject: String,
    private val issuer: String,
    private val tokenExpiresAt: Long,
) : TokenRepository {

    companion object {

        internal const val LOGIN_CLAIM = "LOGIN_CLAIM"
        internal const val PASSWORD_CLAIM = "PASSWORD_CLAIM"
        internal const val ROLES_CLAIM = "ROLES_CLAIM"
    }

    override fun generateToken(login: String, password: String, roles: List<String>): Token =
        buildToken {
            withClaim(LOGIN_CLAIM, login)
            withClaim(PASSWORD_CLAIM, password)
            withClaim(ROLES_CLAIM, roles)
            withExpiresAt(getExpiresAtDate(tokenExpiresAt))
        }


    override fun generateRefreshToken(login: String, password: String, roles: List<String>): Token =
        buildToken {
            withClaim(LOGIN_CLAIM, login)
            withClaim(PASSWORD_CLAIM, password)
            withClaim(ROLES_CLAIM, roles)
        }


    private fun buildToken(block: JWTCreator.Builder.() -> JWTCreator.Builder) = JWT.create()
        .withSubject(subject)
        .withIssuer(issuer)
        .withIssuedAt(Date())
        .block()
        .sign(algorithm)

    private fun getExpiresAtDate(tokenExpiresAt: Long) = Date(Date().time + tokenExpiresAt)
}
