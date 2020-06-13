plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("org.springframework.boot") version "2.3.1.RELEASE"
    application
    id("org.openjfx.javafxplugin")
}



repositories {
    mavenCentral()
}


java {

}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":core"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

javafx {
    version = "14.0.1"
    modules = listOf("javafx.controls")
}

application {
    mainClassName = "com.johupe.samples.TestApplication"

}
