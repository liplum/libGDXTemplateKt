import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    `java-library`
}
val appName: String by project

val mainClassName = "net.liplum.DesktopLauncher"
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
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
    val kotlinVersion: String by project
    implementation(project(":core"))
    api("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}
task<JavaExec>("run") {
    dependsOn("classes")
    mainClass.set(mainClassName)
    classpath = sourceSets.main.get().runtimeClasspath
    standardInput = System.`in`
    workingDir = assetsDir
    isIgnoreExitValue = true
    if (Os.isFamily(Os.FAMILY_MAC)) {
        // Required to run on macOS
        @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
        jvmArgs!!.add("-XstartOnFirstThread")
    }
}
task<JavaExec>("debug") {
    dependsOn("classes")
    mainClass.set(mainClassName)
    classpath = sourceSets.main.get().runtimeClasspath
    standardInput = System.`in`
    workingDir = assetsDir
    isIgnoreExitValue = true
    debug = true
}

task<Jar>("dist") {
    dependsOn(configurations.runtimeClasspath)
    dependsOn("classes")
    from(
        configurations.runtimeClasspath.get().map {
            if (it.isDirectory) it else zipTree(it)
        }
    )
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(mapOf("Main-Class" to mainClassName))
    }
    with(tasks.named<Jar>("jar").get())
}

eclipse {
    project.name = "$appName-desktop"
}
