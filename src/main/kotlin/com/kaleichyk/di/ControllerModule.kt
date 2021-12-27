package com.kaleichyk.di

import com.kaleichyk.controller.UserController
import com.kaleichyk.controller.UserControllerImpl
import org.koin.dsl.module

val controllerModule = module {
    single<UserController> { UserControllerImpl(get()) }
}
