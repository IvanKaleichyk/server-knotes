package com.kaleichyk.di

import com.kaleichyk.repository.UserRepository
import com.kaleichyk.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}
