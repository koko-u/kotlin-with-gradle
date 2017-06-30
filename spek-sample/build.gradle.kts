import jp.co.kokou.sample.ext.filters
import jp.co.kokou.sample.ext.engines
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.junit.platform.gradle.plugin.*

buildscript {

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.3")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-M4")
    }
}

apply {
    plugin<KotlinPlatformJvmPlugin>()
    plugin<JUnitPlatformPlugin>()
}

configure<JUnitPlatformExtension> {
    enableStandardTestTask = true

    filters {
        engines {
            include("junit-jupiter", "spek")
        }
        includeClassNamePatterns(".*Test", ".*Tests", ".*Spec")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compile(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jre8")
    compile(group = "org.jetbrains.kotlin", name = "kotlin-reflect")

    testCompile(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.0.0-M4")
    testRuntime(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.0.0-M4")
    testCompile(group = "org.jetbrains.spek", name = "spek-api", version = "1.1.2")
    testRuntime(group = "org.jetbrains.spek", name = "spek-junit-platform-engine", version = "1.1.2")

    testCompile(group = "org.assertj", name = "assertj-core", version = "3.8.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        javaParameters = true
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
