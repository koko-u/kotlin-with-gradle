import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    id("org.jetbrains.kotlin.jvm") version "1.1.2-2"
    id("com.github.johnrengelman.shadow") version "2.0.0"
    application
}

configure<ApplicationPluginConvention> {
    mainClassName = "jp.co.kokou.sample.MainKt"
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    compile("org.jetbrains.kotlin:kotlin-reflect")

    testCompile("org.jetbrains.kotlin:kotlin-test")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit")

    testCompile("junit:junit:4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        javaParameters = true
        jvmTarget = "1.8"
    }
}
tasks.withType<ShadowJar> {
    with(manifest.attributes) {
        put("Main-Class", "jp.co.kokou.sample.MainKt")
    }
}
