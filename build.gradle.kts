plugins {
    `java-library`
}

val gdxVersion: String by project
val gdxControllersVersion: String by project
val kotlinVersion: String by project

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        google()
    }
    dependencies {
        val kotlinVersion: String by project
        classpath("com.android.tools.build:gradle:7.3.0")
        classpath("com.mobidevelop.robovm:robovm-gradle-plugin:2.3.16")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    apply(plugin = "eclipse")
    version = "1.0"

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/releases/")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

project(":android") {
    apply(plugin = "android")
    apply(plugin = "kotlin-android")

    //configurations { natives }

    dependencies {
        implementation(project(":core"))
        api("com.badlogicgames.gdx:gdx-backend-android:$gdxVersion")
        /*  natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-armeabi-v7a")
          natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-arm64-v8a")
          natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86")
          natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86_64")*/
        api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    }
}
