package com.kaleichyk.repository

import com.kaleichyk.models.UserDetails

interface UserRepository {

    suspend fun getUsers(page: Int = 1, perPage: Int = 10): List<UserDetails>

    suspend fun getUser(id: Long): UserDetails

    suspend fun addUser(userDetails: UserDetails): UserDetails

    suspend fun setUserName(id: Long, name: String): UserDetails

    suspend fun setUserImage(id: Long, url: String): UserDetails
}
