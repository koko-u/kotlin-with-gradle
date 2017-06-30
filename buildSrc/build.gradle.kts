buildscript {

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.3")
    }
}

apply {
    plugin("kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jre8")
    compile(group = "org.jetbrains.kotlin", name = "kotlin-reflect")
    compile(group = "org.junit.platform", name = "junit-platform-gradle-plugin", version = "1.0.0-M4")
}
