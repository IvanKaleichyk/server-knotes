package com.kaleichyk.utils.configuration

import com.kaleichyk.intProperty
import com.kaleichyk.stringProperty
import io.ktor.application.Application

//hostName: String,
//smtpPort: Int,
//account: String,
//username: String,
//password: String

val Application.hostName get() = environment.config.stringProperty(HOST_NAME_PATH)

val Application.smtpPort get() = environment.config.intProperty(SMTP_PORT_PATH)

val Application.email get() = environment.config.stringProperty(EMAIL_PATH)

val Application.username get() = environment.config.stringProperty(USERNAME_PATH)

val Application.password get() = environment.config.stringProperty(PASSWORD_PATH)

private const val HOST_NAME_PATH = "email.host_name"
private const val SMTP_PORT_PATH = "email.smtp_port"
private const val EMAIL_PATH = "email.email"
private const val USERNAME_PATH = "email.username"
private const val PASSWORD_PATH = "email.password"
