package com.kaleichyk.repository

import com.kaleichyk.utils.Token

interface TokenRepository {

    fun generateToken(login: String, password: String, roles: List<String>): Token

    fun generateRefreshToken(login: String, password: String, roles: List<String>): Token
}