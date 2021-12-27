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
    implementation(Dependencies.KTOR_SERVER_CORE)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}