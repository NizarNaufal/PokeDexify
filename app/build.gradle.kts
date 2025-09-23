plugins {
    id("devnzr.android.application.compose")
    alias(libs.plugins.kotlin.serialization)
    id("kotlin-parcelize")
}


android {
    namespace = "id.devnzr.pokedexify"
    compileSdk = 34

    defaultConfig {
        applicationId = "id.devnzr.pokdexify"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            resValue("string", "app_name", "Pokedexify Debug")
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.koinDependencies)
    implementation(projects.navigation)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.datastore)
    implementation(projects.core.models)
    implementation(projects.core.extension)
    implementation(projects.core.uikit)
    implementation(projects.feature.home)
    implementation(projects.feature.login)
    implementation(projects.feature.detail)
    implementation(projects.feature.account)
    implementation(projects.feature.favorites)
    implementation(projects.feature.splash)
}