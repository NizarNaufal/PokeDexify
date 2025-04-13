plugins {
    id("devnzr.android.library")
}

android {
    namespace = "id.devnzr.pokedexify.core.data"
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
    implementation(libs.gson)
    implementation(projects.core.network)
    implementation(projects.core.datastore)
    implementation(projects.core.models)
}