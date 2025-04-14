enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic/convention")
    repositories {
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokeDexify"
include(":app")
include(":core:network")
include(":core:data")
include(":core:datastore")
include(":core:domain")
include(":core:models")
include(":core:database")
include(":feature:home")
include(":feature:detail")
include(":feature:favorites")
include(":feature:login")
include(":feature:account")
include(":core:extension")
include(":core:uikit")
