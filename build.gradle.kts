import kaleichyk.com.Dependencies

plugins {
    application
    kotlin("jvm") version kaleichyk.com.Versions.KOTLIN_VERSION
}

group = "com.kaleichyk"
version = "0.0.1"
application {
    mainClass.set("com.kaleichyk.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.KTOR_SERVER_CORE)
    implementation(Dependencies.KTOR_AUTH)
    implementation(Dependencies.KTOR_AUTH_JWT)
    implementation(Dependencies.KTOR_METRICS)
    implementation(Dependencies.KTOR_METRICS_MICROMETER)
    implementation(Dependencies.MICROMETER_REGISTRY_PROMETHEUS)
    implementation(Dependencies.KTOR_GSON)
    implementation(Dependencies.KTOR_SERVER_NETTY)
    implementation(Dependencies.LOGBACK_CLASSIC)
    implementation(Dependencies.KTOR_SERVER_TESTS)
    implementation(Dependencies.KOTLIN_TEST_JUNIT)
}