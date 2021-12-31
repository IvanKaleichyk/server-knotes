package com.kaleichyk.controller

import com.kaleichyk.LoginBody
import com.kaleichyk.interactor.AuthInteractor
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.utils.Token

class AuthControllerImpl(
    private val interactor: AuthInteractor
) : AuthController {

    override suspend fun login(body: LoginBody) = interactor.login(body)

    override suspend fun createAccount(userDetailsBody: UserDetailsBody) = interactor.createAccount(userDetailsBody)

    override suspend fun refreshToken(refreshToken: Token) = interactor.refreshToken(refreshToken)
}