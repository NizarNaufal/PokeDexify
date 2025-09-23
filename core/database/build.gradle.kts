plugins {
    id("devnzr.android.library")
    alias(libs.plugins.ksp)
}

android {
    namespace = "id.devnzr.pokedexify.database"
    compileSdk = libs.versions.compileSdk.get().toIntOrNull()
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

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.bundles.koinDependencies)
    implementation(libs.androidx.room.ktx)
    implementation(projects.core.models)
    api(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.gson)
}