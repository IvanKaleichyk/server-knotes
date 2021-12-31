package com.kaleichyk.controller

import com.kaleichyk.interactor.UserInteractor

class UserControllerImpl(
    private val interactor: UserInteractor
) : UserController {

    override suspend fun getUsers(page: Int, perPage: Int) = interactor.getUsers(page, perPage)

    override suspend fun getUser(id: Long) = interactor.getUser(id)

    override suspend fun setUserName(id: Long, name: String) = interactor.setUserName(id, name)

    override suspend fun setUserImage(id: Long, url: String) = interactor.setUserImage(id, url)
}
