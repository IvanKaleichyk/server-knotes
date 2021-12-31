package com.kaleichyk.service

import com.kaleichyk.exceptions.AlreadyExistsException
import com.kaleichyk.models.UserDetails
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.repository.UserRepository
import com.kaleichyk.verifier.email.EmailValidator
import com.kaleichyk.verifier.password.PasswordValidator

class UserServiceImpl(
    private val repository: UserRepository,
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator
) : UserService {

    override suspend fun getUsers(page: Int, perPage: Int) = repository.getUsers(page, perPage)

    override suspend fun getUser(id: Long) = repository.getUser(id)

    override suspend fun addUser(userDetails: UserDetailsBody): UserDetails {
        passwordValidator.validate(userDetails.password)
        emailValidator.validate(userDetails.email)
        try {
            return repository.addUser(userDetails)
        } catch (e: Exception) {
            throw AlreadyExistsException("User with this email (${userDetails.email} already exists)")
        }
    }

    override suspend fun setUserName(id: Long, name: String) = repository.setUserName(id, name)

    override suspend fun setUserImage(id: Long, url: String) = repository.setUserImage(id, url)

    override suspend fun checkUserCredentials(email: String, password: String) =
        repository.checkUserCredentials(email, password)
}
