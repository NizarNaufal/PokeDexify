plugins {
    id("devnzr.android.library.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "id.devnzr.pokedexify.feature.detail"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        getByName("debug")
        getByName("release")
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.bundles.koinDependencies)
    implementation(projects.core.domain)
    implementation(libs.bundles.supportDependencies)
    implementation(libs.kotlinx.serialization.json)
}