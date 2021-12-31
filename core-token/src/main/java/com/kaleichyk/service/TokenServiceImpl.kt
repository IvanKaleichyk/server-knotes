package com.kaleichyk.service

import com.kaleichyk.repository.TokenRepository
import com.kaleichyk.utils.Token
import com.kaleichyk.utils.Tokens
import com.kaleichyk.utils.extentension.getLogin
import com.kaleichyk.utils.extentension.getPassword
import com.kaleichyk.utils.extentension.getRoles
import com.kaleichyk.verifier.TokenVerifier

class TokenServiceImpl(
    private val repository: TokenRepository,
    private val verifier: TokenVerifier
) : TokenService {

    override fun generateTokens(login: String, password: String, roles: List<String>) = repository.run {
        Tokens(
            generateToken(login, password, roles),
            generateRefreshToken(login, password, roles)
        )
    }

    override fun refreshToken(refreshToken: Token) = verifier.getDecodedJWT(refreshToken).run {
        verifier.isTokenValid(refreshToken)
        repository.generateToken(getLogin(), getPassword(), getRoles())
    }

    override fun isTokenValid(token: Token) = verifier.isTokenValid(token)
}
