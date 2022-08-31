/*
 * https://docs.gradle.org/7.4.2/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    `java-library`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.4.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.3.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation ("com.codeborne:selenide:6.7.2")

    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.seleniumhq.selenium:selenium-java:4.4.0")
}

application {
    mainClass.set("le.at.gui.slnm.s00.App")
}

tasks.named<Test>("test") {
    // Use TestNG for unit tests.
    useTestNG()
}
