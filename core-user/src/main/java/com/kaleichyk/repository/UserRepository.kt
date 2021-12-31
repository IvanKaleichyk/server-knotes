package com.kaleichyk.repository

import com.kaleichyk.models.UserDetails
import com.kaleichyk.models.UserDetailsBody

interface UserRepository {

    suspend fun getUsers(page: Int = 1, perPage: Int = 10): List<UserDetails>

    suspend fun getUser(id: Long): UserDetails

    suspend fun addUser(userDetails: UserDetailsBody): UserDetails

    suspend fun setUserName(id: Long, name: String): UserDetails

    suspend fun setUserImage(id: Long, url: String): UserDetails

    suspend fun checkUserCredentials(email: String, password: String): Boolean
}
