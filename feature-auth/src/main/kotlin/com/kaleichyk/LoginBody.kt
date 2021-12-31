package com.kaleichyk

data class LoginBody(val email: String, val password: String, val roles: List<String>)
