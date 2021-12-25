import kaleichyk.com.Dependencies

plugins {
    java
    kotlin("jvm")
}

group = "com.kaleichyk"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common-utils"))

    implementation(Dependencies.KTOR_SERVER_CORE)
    implementation(Dependencies.KTOR_AUTH)
    implementation(Dependencies.KTOR_AUTH_JWT)

    testImplementation(Dependencies.KOTLIN_TEST_JUNIT)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}