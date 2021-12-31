package com.kaleichyk.service

import com.kaleichyk.utils.Token
import com.kaleichyk.utils.Tokens

interface TokenService {

    fun generateTokens(login: String, password: String, roles: List<String>): Tokens

    fun refreshToken(refreshToken: Token): Token

    fun isTokenValid(token: Token)
}
