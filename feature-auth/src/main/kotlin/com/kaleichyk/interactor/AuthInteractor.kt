package com.kaleichyk.interactor

import com.kaleichyk.LoginBody
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.utils.Token
import com.kaleichyk.utils.Tokens

interface AuthInteractor {

    suspend fun login(body: LoginBody): Tokens

    suspend fun createAccount(userDetailsBody: UserDetailsBody): Tokens

    suspend fun refreshToken(refreshToken: Token): Token

    suspend fun validateCredential(email: String, password: String): Boolean
}