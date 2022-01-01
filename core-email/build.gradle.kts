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
    implementation(Dependencies.APACHE_EMAIL)
    implementation(Dependencies.KOIN_BASE)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}