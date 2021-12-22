package com.kaleichyk.plugins

import com.kaleichyk.di.controllerModule
import com.kaleichyk.di.interactorModule
import com.kaleichyk.di.repositoryModule
import com.kaleichyk.di.serviceModule
import com.kaleichyk.di.utilsModule
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.ktor.ext.Koin

fun Application.configureDI() {
    install(Koin) {
        modules(
            controllerModule,
            interactorModule,
            repositoryModule,
            serviceModule,
            utilsModule
        )
    }
}
