package com.kaleichyk.repository

import com.kaleichyk.entity.UserDetailsEntity
import com.kaleichyk.exceptions.AlreadyExistsException
import com.kaleichyk.exceptions.CannotFindException
import com.kaleichyk.extensions.getOffset
import com.kaleichyk.models.UserDetails
import com.kaleichyk.models.UserDetailsBody
import com.kaleichyk.models.toUserDetails
import com.kaleichyk.table.UserDetailsTable
import com.kaleichyk.utils.exception.UserNotExist
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserRepositoryImpl : UserRepository {

    override suspend fun getUsers(page: Int, perPage: Int) = newSuspendedTransaction {
        UserDetailsEntity.all().limit(perPage, getOffset(page, perPage)).map { it.toUserDetails() }
    }

    override suspend fun getUser(id: Long) = newSuspendedTransaction {
        UserDetailsEntity.findById(id)?.toUserDetails() ?: throw CannotFindException("Cannot find user with id = $id")
    }

    override suspend fun addUser(userDetails: UserDetailsBody): UserDetails = newSuspendedTransaction {
        val user = UserDetailsEntity.new {
            name = userDetails.name
            password = userDetails.password
            image = userDetails.image
            about = userDetails.about
            email = userDetails.email
        }

        try {
            user.toUserDetails()
        } catch (e: Exception) {
            val exceptionMessage =
                "User with this email (${userDetails.email}) or name (${userDetails.name}) already exists"
            throw AlreadyExistsException(exceptionMessage)
        }
    }

    override suspend fun setUserName(id: Long, name: String) = newSuspendedTransaction {
        val user = UserDetailsEntity.findById(id) ?: throw CannotFindException("Cannot find user by id = $id")
        user.name = name
        user.toUserDetails()
    }

    override suspend fun setUserImage(id: Long, url: String) = newSuspendedTransaction {
        val user = UserDetailsEntity.findById(id) ?: throw CannotFindException("Cannot find user by id = $id")
        user.image = url
        user.toUserDetails()
    }

    override suspend fun checkUserCredentials(email: String, password: String): Boolean {
        val user =
            UserDetailsEntity.find { UserDetailsTable.email eq email }.limit(1).firstOrNull() ?: throw UserNotExist()

        return user.password == password
    }
}
