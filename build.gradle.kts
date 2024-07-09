plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val allureVersion = "2.25.0"
val aspectJVersion = "1.9.21"

val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.microsoft.playwright:playwright:1.45.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3")
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    testImplementation("io.qameta.allure:allure-junit5")
    agent("org.aspectj:aspectjweaver:${aspectJVersion}")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf(
        "-javaagent:${agent.singleFile}"
    )
}