package com.kaleichyk.di

import com.kaleichyk.interactor.UserInteractor
import com.kaleichyk.interactor.UserInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<UserInteractor> { UserInteractorImpl(get()) }
}
