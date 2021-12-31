package com.kaleichyk.di

import com.kaleichyk.controller.UserController
import com.kaleichyk.controller.UserControllerImpl
import com.kaleichyk.interactor.UserInteractor
import com.kaleichyk.interactor.UserInteractorImpl
import org.koin.dsl.module

val featureUserModule = module {
    single<UserController> { UserControllerImpl(get()) }
    single<UserInteractor> { UserInteractorImpl(get()) }
}