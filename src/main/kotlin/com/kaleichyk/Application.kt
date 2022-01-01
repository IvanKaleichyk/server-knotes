package com.kaleichyk

import com.kaleichyk.controller.AuthController
import com.kaleichyk.controller.UserController
import com.kaleichyk.interactor.AuthInteractor
import com.kaleichyk.plugins.configureDI
import com.kaleichyk.plugins.configureHTTP
import com.kaleichyk.plugins.configureMonitoring
import com.kaleichyk.plugins.configureSerialization
import com.kaleichyk.plugins.configureStatusPage
import com.kaleichyk.route.configureTestRoute
import com.kaleichyk.service.EmailService
import com.kaleichyk.table.UserDetailsTable
import com.kaleichyk.utils.extension.databaseDriver
import com.kaleichyk.utils.extension.databasePassword
import com.kaleichyk.utils.extension.databaseUrl
import com.kaleichyk.utils.extension.databaseUser
import com.kaleichyk.utils.extentension.realm
import com.kaleichyk.verifier.TokenVerifier
import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject

fun main(args: Array<String>) = EngineMain.main(args)

@Suppress("UNUSED")
fun Application.module() {
    configureDI()
    configureDatabase()
    configureSecurity(inject<AuthInteractor>().value, inject<TokenVerifier>().value.verifier, realm)
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureStatusPage()

    routing {
        configureTestRoute()
        createUserRoute(inject<UserController>().value)
        createAuthRoute(inject<AuthController>().value)
    }
}

private fun Application.configureDatabase() {
    Database.connect(databaseUrl, databaseDriver, databaseUser, databasePassword)

    transaction {
        SchemaUtils.create(UserDetailsTable)
    }
}
