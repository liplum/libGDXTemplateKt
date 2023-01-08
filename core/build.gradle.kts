plugins {
    `java-library`
}
val appName: String by project

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}
dependencies {
    val gdxVersion: String by project
    val kotlinVersion: String by project
    api("com.badlogicgames.gdx:gdx:$gdxVersion")
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}
tasks.named<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}
tasks.named<JavaCompile>("compileTestJava") {
    options.encoding = "UTF-8"
}
sourceSets {
    main {
        java.srcDirs("src")
    }
}
eclipse {
    project.name = "$appName-core"
}
