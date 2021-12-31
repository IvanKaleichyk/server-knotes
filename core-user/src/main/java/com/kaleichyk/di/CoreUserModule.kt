package com.kaleichyk.di

import com.kaleichyk.repository.UserRepository
import com.kaleichyk.repository.UserRepositoryImpl
import com.kaleichyk.service.UserService
import com.kaleichyk.service.UserServiceImpl
import com.kaleichyk.verifier.email.EmailValidator
import com.kaleichyk.verifier.email.EmailValidatorImpl
import com.kaleichyk.verifier.password.PasswordValidator
import com.kaleichyk.verifier.password.PasswordValidatorImpl
import org.koin.dsl.module

val coreUserModule = module {
    single<UserService> { UserServiceImpl(get(), get(), get()) }
    single<UserRepository> { UserRepositoryImpl() }
    single<EmailValidator> { EmailValidatorImpl() }
    single<PasswordValidator> { PasswordValidatorImpl() }
}
