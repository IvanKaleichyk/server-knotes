package com.kaleichyk.service

import com.kaleichyk.models.UserDetails
import com.kaleichyk.repository.UserRepository

class UserServiceImpl(
    private val repository: UserRepository
) : UserService {

    override suspend fun getUsers(page: Int, perPage: Int) = repository.getUsers(page, perPage)

    override suspend fun getUser(id: Long) = repository.getUser(id)

    override suspend fun addUser(userDetails: UserDetails) = repository.addUser(userDetails)

    override suspend fun setUserName(id: Long, name: String) = repository.setUserName(id, name)

    override suspend fun setUserImage(id: Long, url: String) = repository.setUserImage(id, url)
}
