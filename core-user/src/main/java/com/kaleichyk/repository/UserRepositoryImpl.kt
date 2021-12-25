package com.kaleichyk.repository

import com.kaleichyk.entity.UserDetailsEntity
import com.kaleichyk.exceptions.CannotFindException
import com.kaleichyk.extensions.getOffset
import com.kaleichyk.models.UserDetails
import com.kaleichyk.models.toUserDetails
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserRepositoryImpl : UserRepository {

    override suspend fun getUsers(page: Int, perPage: Int) = newSuspendedTransaction {
        UserDetailsEntity.all().limit(perPage, getOffset(page, perPage)).map { it.toUserDetails() }
    }

    override suspend fun getUser(id: Long) = newSuspendedTransaction {
        UserDetailsEntity.findById(id)?.toUserDetails() ?: throw CannotFindException("Cannot find user with id = $id")
    }

    override suspend fun addUser(userDetails: UserDetails) = newSuspendedTransaction {
        val user = UserDetailsEntity.new {
            name = userDetails.name
            image = userDetails.image
            about = userDetails.about
            email = userDetails.email
        }
        user.toUserDetails()
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
}
