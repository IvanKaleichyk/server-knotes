package com.kaleichyk.interactor

import com.kaleichyk.service.UserService

class UserInteractorImpl(
    private val service: UserService
) : UserInteractor {

    override suspend fun getUsers(page: Int, perPage: Int) = service.getUsers(page, perPage)

    override suspend fun getUser(id: Long) = service.getUser(id)

    override suspend fun setUserName(id: Long, name: String) = service.setUserName(id, name)

    override suspend fun setUserImage(id: Long, url: String) = service.setUserImage(id, url)
}
