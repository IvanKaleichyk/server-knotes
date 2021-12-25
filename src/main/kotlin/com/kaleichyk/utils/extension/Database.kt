package com.kaleichyk.utils.extension

import com.kaleichyk.exceptions.stringProperty
import io.ktor.application.Application

val Application.databaseUrl get() = environment.config.stringProperty(DATABASE_URL_PATH)

val Application.databaseDriver get() = environment.config.stringProperty(DATABASE_DRIVER_PATH)

val Application.databaseUser get() = environment.config.stringProperty(DATABASE_USER_PATH)

val Application.databasePassword get() = environment.config.stringProperty(DATABASE_PASSWORD_PATH)

private const val DATABASE_URL_PATH = "database.url"

private const val DATABASE_DRIVER_PATH = "database.driver"

private const val DATABASE_USER_PATH = "database.user"

private const val DATABASE_PASSWORD_PATH = "database.password"
