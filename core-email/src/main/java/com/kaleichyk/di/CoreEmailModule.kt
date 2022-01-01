package com.kaleichyk.di

import com.kaleichyk.repository.EmailRepository
import com.kaleichyk.repository.EmailRepositoryImpl
import com.kaleichyk.service.EmailService
import com.kaleichyk.service.EmailServiceImpl
import org.koin.dsl.module

fun getCoreEmailModule(
    hostName: String,
    smtpPort: Int,
    email: String,
    username: String,
    password: String
) = module {
    single<EmailService> { EmailServiceImpl(get()) }
    single<EmailRepository> { EmailRepositoryImpl(hostName, smtpPort, email, username, password) }
}