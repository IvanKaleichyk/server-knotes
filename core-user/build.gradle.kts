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

    implementation(Dependencies.EXPOSED_CORE)
    implementation(Dependencies.EXPOSED_DAO)
    implementation(Dependencies.EXPOSED_JDBC)

    implementation(Dependencies.KOIN_BASE)

    implementation(Dependencies.BCRYPT)

    testImplementation(Dependencies.KOTLIN_TEST_JUNIT)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
