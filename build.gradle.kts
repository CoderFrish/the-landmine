plugins {
    id("net.fabricmc.fabric-loom") version "1.16-SNAPSHOT"
    kotlin("jvm") version "2.3.21"
}

group = "me.coderfrish"
version = "1.1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(25)
}

dependencies {
    minecraft("com.mojang:minecraft:26.1.2")
    implementation("net.fabricmc:fabric-loader:0.19.2")
    implementation("net.fabricmc:fabric-language-kotlin:1.13.11+kotlin.2.3.21")
    implementation("net.fabricmc.fabric-api:fabric-api:0.148.0+26.1.2")
}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

tasks {
    jar {
        from("LICENSE.md")
    }

    processResources {
        inputs.property("version", version)

        filesMatching("fabric.mod.json") {
            expand("version" to version)
        }
    }
}
