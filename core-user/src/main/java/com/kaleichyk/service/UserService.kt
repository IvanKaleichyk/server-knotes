package com.kaleichyk.service

import com.kaleichyk.models.UserDetails

interface UserService {

    companion object{

        const val USER_PER_PAGE = 10
        const val USER_DEFAULT_PAGE = 1
    }

    suspend fun getUsers(page: Int, perPage: Int = USER_PER_PAGE): List<UserDetails>

    suspend fun getUser(id: Long): UserDetails

    suspend fun addUser(userDetails: UserDetails): UserDetails

    suspend fun setUserName(id: Long, name: String): UserDetails

    suspend fun setUserImage(id: Long, url: String): UserDetails
}
