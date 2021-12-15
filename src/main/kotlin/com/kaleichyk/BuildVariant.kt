package com.kaleichyk

object BuildVariant {
    val buildVariant = BuildVariantType.DEBUG
}

enum class BuildVariantType {
    DEBUG, RELEASE
}