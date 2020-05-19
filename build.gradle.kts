group = "com.github.aesteve"
version = "0.0.1-SNAPSHOT"

plugins {
    id("org.jetbrains.kotlin.jvm") version("1.3.72")
    id("io.quarkus") version("1.4.2.Final")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:1.4.2.Final"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.quarkus:quarkus-kotlin")
    testImplementation("io.quarkus:quarkus-junit5")
}

tasks.withType<Wrapper> {
    gradleVersion = "6.4"
}
