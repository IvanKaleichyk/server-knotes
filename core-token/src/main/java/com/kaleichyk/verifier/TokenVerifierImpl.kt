package com.kaleichyk.verifier

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.kaleichyk.exceptions.AuthException
import com.kaleichyk.utils.Token

class TokenVerifierImpl(algorithm: Algorithm, issuer: String) : TokenVerifier {

    override val verifier: JWTVerifier = JWT.require(algorithm).withIssuer(issuer).build()

    override fun isTokenValid(token: Token) {
        val tokenNotValidMessage = "Token is not valid"
        try {
            verifier.verify(token) ?: throw TokenVerifierException(tokenNotValidMessage)
        } catch (e: JWTVerificationException) {
            throw TokenVerifierException(tokenNotValidMessage)
        }
    }

    override fun getDecodedJWT(token: Token) = try {
        verifier.verify(token) ?: throw AuthException()
    } catch (e: JWTVerificationException) {
        throw AuthException()
    }
}
