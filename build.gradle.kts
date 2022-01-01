import kaleichyk.com.Dependencies
import kaleichyk.com.Versions

plugins {
    application
    kotlin("jvm") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.0"
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

group = "com.kaleichyk"
version = "0.0.1"
application {
    mainClass.set("com.kaleichyk.ApplicationKt")
}

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1")
    }
}

detekt {
    toolVersion = Versions.DETEKT_VERSION
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    config =
        files("$projectDir/config/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
    baseline = file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
        sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = "1.8"
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
    jvmTarget = "1.8"
}


dependencies {
    implementation(project(":feature-auth"))
    implementation(project(":feature-user"))
    implementation(project(":core-user"))
    implementation(project(":core-token"))
    implementation(project(":common-utils"))

    implementation(Dependencies.KTOR_SERVER_CORE)

    implementation(Dependencies.KTOR_AUTH_JWT)

    implementation(Dependencies.KTOR_METRICS)
    implementation(Dependencies.KTOR_METRICS_MICROMETER)

    implementation(Dependencies.MICROMETER_REGISTRY_PROMETHEUS)
    implementation(Dependencies.KTOR_GSON)
    implementation(Dependencies.KTOR_SERVER_NETTY)

//  DI
    implementation(Dependencies.KOIN_KTOR)

//  Logs
    implementation(Dependencies.LOGBACK_CLASSIC)

//  Database
    implementation(Dependencies.EXPOSED_CORE)
    implementation(Dependencies.EXPOSED_DAO)
    implementation(Dependencies.EXPOSED_JDBC)

    implementation("org.postgresql:postgresql:42.3.1")

    implementation(Dependencies.KTOR_SERVER_TESTS)
    implementation(Dependencies.KOTLIN_TEST_JUNIT)
}