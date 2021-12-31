package com.kaleichyk.di

import com.kaleichyk.controller.AuthController
import com.kaleichyk.controller.AuthControllerImpl
import com.kaleichyk.interactor.AuthInteractor
import com.kaleichyk.interactor.AuthInteractorImpl
import org.koin.dsl.module

val featureAuthModule = module {
    single<AuthController> { AuthControllerImpl(get()) }
    single<AuthInteractor> { AuthInteractorImpl(get(), get()) }
}