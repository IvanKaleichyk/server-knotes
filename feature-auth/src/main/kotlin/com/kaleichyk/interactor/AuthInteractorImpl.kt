package com.kaleichyk.interactor

import com.kaleichyk.LoginBody
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.service.TokenService
import com.kaleichyk.service.UserService
import com.kaleichyk.utils.Token
import com.kaleichyk.utils.Tokens
import com.kaleichyk.utils.exception.WrongDataException

class AuthInteractorImpl(
    private val tokenService: TokenService,
    private val userService: UserService,
) : AuthInteractor {

    override suspend fun login(body: LoginBody): Tokens {
        val isPasswordCorrect = userService.checkUserCredentials(body.email, body.password)
        if (!isPasswordCorrect) throw WrongDataException("Wrong password")

        return tokenService.generateTokens(body.email, body.password, body.roles)
    }

    override suspend fun createAccount(userDetailsBody: UserDetailsBody) = userDetailsBody.run {
        userService.addUser(this)
        tokenService.generateTokens(email, password, roles)
    }

    override suspend fun refreshToken(refreshToken: Token) = tokenService.refreshToken(refreshToken)

    override suspend fun validateCredential(email: String, password: String) =
        userService.checkUserCredentials(email, password)
}