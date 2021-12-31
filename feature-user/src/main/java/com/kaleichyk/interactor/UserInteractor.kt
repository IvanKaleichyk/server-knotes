package com.kaleichyk.interactor

import com.kaleichyk.models.UserDetails
import com.kaleichyk.service.UserService

interface UserInteractor {

    suspend fun getUsers(page: Int, perPage: Int = UserService.USER_PER_PAGE): List<UserDetails>

    suspend fun getUser(id: Long): UserDetails

    suspend fun setUserName(id: Long, name: String): UserDetails

    suspend fun setUserImage(id: Long, url: String): UserDetails
}
