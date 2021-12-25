package com.kaleichyk.models

import com.kaleichyk.entity.UserDetailsEntity
import com.kaleichyk.utils.getOnlineTime
import java.util.*

data class UserDetails(
    val id: Long = 0,
    val name: String,
    val email: String,
    val image: String? = null,
    val about: String? = null,
    val online: Long = Date().time
)

fun UserDetailsEntity.toUserDetails() = UserDetails(
    id.value,
    name,
    email,
    image,
    about,
    getOnlineTime(lastUpdated)
)
