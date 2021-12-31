package com.kaleichyk.di

import com.auth0.jwt.algorithms.Algorithm
import com.kaleichyk.repository.TokenRepository
import com.kaleichyk.repository.TokenRepositoryImpl
import com.kaleichyk.service.TokenService
import com.kaleichyk.service.TokenServiceImpl
import com.kaleichyk.verifier.TokenVerifier
import com.kaleichyk.verifier.TokenVerifierImpl
import org.koin.dsl.module

fun getCoreTokenModule(algorithm: Algorithm, subject: String, issuer: String, tokenExpiresAt: Long) = module {
    single<TokenService> { TokenServiceImpl(get(), get()) }
    single<TokenVerifier> { TokenVerifierImpl(algorithm, issuer) }
    single<TokenRepository> { TokenRepositoryImpl(algorithm, subject, issuer, tokenExpiresAt) }
}
