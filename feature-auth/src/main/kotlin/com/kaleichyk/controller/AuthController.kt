package com.kaleichyk.controller

import com.kaleichyk.LoginBody
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.utils.Token
import com.kaleichyk.utils.Tokens

interface AuthController {

    suspend fun login(body: LoginBody): Tokens

    suspend fun createAccount(userDetailsBody: UserDetailsBody): Tokens

    suspend fun refreshToken(refreshToken: Token): Token
}