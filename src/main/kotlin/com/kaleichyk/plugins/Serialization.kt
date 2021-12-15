package com.kaleichyk.plugins

import com.google.gson.FieldNamingPolicy
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import java.text.DateFormat

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }
}
