import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.maven.publish)
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm("desktop")

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64(),
//    ).forEach { iosTarget ->
//        iosTarget.binaries.framework {
//            baseName = "lib"
//            isStatic = true
//        }
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                compileOnly(compose.runtime)
                compileOnly(compose.foundation)
                compileOnly(compose.material3)
                compileOnly(libs.compose.multiplatform.navigation)
            }
        }
        val androidMain by getting
//        val iosX64Main by getting
//        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating
        val desktopMain by getting
    }
}

android {
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
    namespace = "dev.medzik.jetkit"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.android.sdk.min.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates(group.toString(), "jetkit", version.toString())

    pom {
        inceptionYear = "2024"
        url = "https://gitlab.com/medzik/jetkit"

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        developers {
            developer {
                name = "Oskar Karpiński"
                email = "me@medzik.dev"
            }
        }

        scm {
            connection = "scm:git@gitlab.com:medzik/jetkit.git"
            developerConnection = "scm:git@gitlab.com:medzik/jetkit.git"
            url = "scm:git@gitlab.com:medzik/jetkit.git"
        }
    }
}
