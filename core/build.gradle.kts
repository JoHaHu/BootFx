plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.openjfx.javafxplugin")
    java
}



dependencies{

    api(kotlin("stdlib"))

    api("org.springframework.boot","spring-boot-starter")

}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

javafx {
    version = "14.0.1"
    modules = listOf("javafx.controls")
    configuration = "compileOnly"
}