package com.kaleichyk.di

import com.kaleichyk.service.UserService
import com.kaleichyk.service.UserServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single<UserService> { UserServiceImpl(get()) }
}
