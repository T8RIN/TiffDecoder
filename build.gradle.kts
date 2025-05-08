plugins {
    id("com.android.library") version "8.10.0"
    id("maven-publish")
}

val libVersion = "1.0.0"

android {
    compileSdk = 36
    namespace = "org.beyka.tiffbitmapfactory"

    val softwareName = """"${project.name}-$libVersion""""

    defaultConfig {
        minSdk = 16
    }

    buildTypes {
        release {
            buildConfigField("String", "softwarename", softwareName)
        }
        debug {
            buildConfigField("String", "softwarename", softwareName)
        }
    }

    buildFeatures {
        buildConfig = true
        resValues = true
    }

    ndkVersion = "26.1.10909125"
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                groupId = "com.github.t8rin"
                artifactId = "tiff-factory"
                version = libVersion
                from(components.findByName("release"))
            }
        }
    }
}