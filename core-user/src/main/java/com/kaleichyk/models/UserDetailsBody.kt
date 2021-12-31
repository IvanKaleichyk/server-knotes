package com.kaleichyk.models

data class UserDetailsBody(
    val name: String,
    val email: String,
    val password: String,
    val image: String? = null,
    val about: String? = null,
    val roles: List<String>
)
