@file:Suppress("UnstableApiUsage")

val appName: String by project
plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    buildToolsVersion = "30.0.3"
    compileSdkVersion = "android-33"
    sourceSets {
        named("main") {
            res.srcDir("res")
            assets.srcDir("../assets")
            jniLibs.srcDir("libs")
        }
    }
    defaultConfig {
        val appVersion: String by project
        val applicationId: String by project
        this.applicationId = applicationId
        minSdk = 14
        targetSdk = 33
        versionCode = appVersion.split('.').joinToString("") { it.padStart(2, '0') }.toInt()
        versionName = appVersion
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

val natives: Configuration by configurations.creating

dependencies {
    val gdxVersion: String by project

    implementation(project(":core"))

    implementation(kotlin("stdlib"))

    implementation("com.badlogicgames.gdx:gdx-backend-android:$gdxVersion")

    natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-arm64-v8a")
    natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86")
    natives("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86_64")
}

// Called every time gradle gets executed, takes the native dependencies of
// the natives configuration, and extracts them to the proper libs/ folders
// so they get packed with the APK.
tasks.register("copyAndroidNatives") {
    doFirst {
        natives.files.forEach { jar ->
            val outputDir = file("libs/" + jar.nameWithoutExtension.substringAfterLast("natives-"))
            outputDir.mkdirs()
            copy {
                from(zipTree(jar))
                into(outputDir)
                include("*.so")
            }
        }
    }
}
tasks.whenTaskAdded {
    if ("package" in name) {
        dependsOn("copyAndroidNatives")
    }
}
eclipse.project {
    name = "$appName-android"
}