plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"  apply false
    kotlin("plugin.jpa") version "1.3.72" apply false
    id("org.openjfx.javafxplugin") version "0.0.9-SNAPSHOT" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

subprojects {
    apply(plugin="io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.3.1.RELEASE")
        }
    }

    repositories {
        mavenCentral()
        jcenter()
    }

}

