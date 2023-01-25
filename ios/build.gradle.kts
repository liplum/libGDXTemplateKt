plugins {
    `java-library`
    id("robovm")
}
val appName: String by project

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}
val assetsDir = File("../assets")
sourceSets {
    main {
        java.srcDirs("src")
        resources.srcDirs("../assets")
    }
}
dependencies {
    val gdxVersion: String by project
    val roboVMVersion: String by project
    val kotlinVersion: String by project
    implementation(project(":core"))
    api("com.mobidevelop.robovm:robovm-rt:$roboVMVersion")
    api("com.mobidevelop.robovm:robovm-cocoatouch:$roboVMVersion")
    api("com.badlogicgames.gdx:gdx-backend-robovm:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-ios")
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}
tasks.named<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}
tasks.named<JavaCompile>("compileTestJava") {
    options.encoding = "UTF-8"
}
val mainClassName = "net.liplum.IOSLauncher"
tasks.named("launchIPhoneSimulator") {
    dependsOn("build")
}
tasks.named("launchIPhoneSimulator") {
    dependsOn("build")
}
tasks.named("launchIPadSimulator") {
    dependsOn("build")
}
tasks.named("launchIOSDevice") {
    dependsOn("build")
}
tasks.named("createIPA") {
    dependsOn("build")
}
robovm {
    archs = "thumbv7:arm64"
}
eclipse {
    project.name = "$appName-ios"
}
