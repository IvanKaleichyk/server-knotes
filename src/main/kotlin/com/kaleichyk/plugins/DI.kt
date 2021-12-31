package com.kaleichyk.plugins

import com.kaleichyk.di.coreUserModule
import com.kaleichyk.di.featureAuthModule
import com.kaleichyk.di.featureUserModule
import com.kaleichyk.di.getCoreTokenModule
import com.kaleichyk.di.utilsModule
import com.kaleichyk.utils.extentension.algorithm
import com.kaleichyk.utils.extentension.issuer
import com.kaleichyk.utils.extentension.subject
import com.kaleichyk.utils.extentension.tokenValidTime
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.ktor.ext.Koin

fun Application.configureDI() {
    install(Koin) {
        modules(
            getCoreTokenModule(algorithm, subject, issuer, tokenValidTime),
            coreUserModule,
            featureAuthModule,
            featureUserModule,
            utilsModule
        )
    }
}
