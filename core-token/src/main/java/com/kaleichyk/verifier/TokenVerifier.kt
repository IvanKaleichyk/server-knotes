package com.kaleichyk.verifier

import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import com.kaleichyk.utils.Token

interface TokenVerifier {

    val verifier: JWTVerifier

    fun isTokenValid(token: Token)

    fun getDecodedJWT(token: Token): DecodedJWT
}
