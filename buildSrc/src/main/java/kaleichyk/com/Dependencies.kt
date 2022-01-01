package kaleichyk.com

object Dependencies {

    const val KTOR_SERVER_CORE = "io.ktor:ktor-server-core:${Versions.KTOR_VERSION}"
    const val KTOR_AUTH = "io.ktor:ktor-auth:${Versions.KTOR_VERSION}"
    const val KTOR_AUTH_JWT = "io.ktor:ktor-auth-jwt:${Versions.KTOR_VERSION}"
    const val KTOR_METRICS = "io.ktor:ktor-metrics:${Versions.KTOR_VERSION}"
    const val KTOR_METRICS_MICROMETER = "io.ktor:ktor-metrics-micrometer:${Versions.KTOR_VERSION}"

    const val MICROMETER_REGISTRY_PROMETHEUS =
        "io.micrometer:micrometer-registry-prometheus:${Versions.PROMETEUS_VERSION}"
    const val KTOR_SERIALIZABLE = "io.ktor:ktor-serialization:${Versions.KTOR_VERSION}"
    const val KTOR_GSON = "io.ktor:ktor-gson:${Versions.KTOR_VERSION}"
    const val KTOR_SERVER_NETTY = "io.ktor:ktor-server-netty:${Versions.KTOR_VERSION}"

    // DI
    const val KOIN_BASE = "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
    const val KOIN_KTOR = "io.insert-koin:koin-ktor:${Versions.KOIN_VERSION}"

    // HASH PASSWORD
    const val BCRYPT = "org.mindrot:jbcrypt:${Versions.BCRYPT_VERSION}"

    // DATABASE
    const val EXPOSED_CORE = "org.jetbrains.exposed:exposed-core:${Versions.EXPOSED_VERSION}"
    const val EXPOSED_DAO = "org.jetbrains.exposed:exposed-dao:${Versions.EXPOSED_VERSION}"
    const val EXPOSED_JDBC = "org.jetbrains.exposed:exposed-jdbc:${Versions.EXPOSED_VERSION}"

    const val LOGBACK_CLASSIC = "ch.qos.logback:logback-classic:${Versions.LOGBACK_VERSION}"

    const val KTOR_SERVER_TESTS = "io.ktor:ktor-server-tests:${Versions.KTOR_VERSION}"
    const val KOTLIN_TEST_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN_VERSION}"
}