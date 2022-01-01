package com.kaleichyk

import io.ktor.config.ApplicationConfig

fun ApplicationConfig.stringProperty(path: String) = property(prefix + path).getString()

fun ApplicationConfig.intProperty(path: String) = property(prefix + path).getString().toInt()

fun ApplicationConfig.longProperty(path: String) = property(prefix + path).getString().toLong()

private val prefix = when (BuildVariant.buildVariantType) {
    BuildVariantType.DEBUG -> "debug."
    BuildVariantType.RELEASE -> "release."
}
