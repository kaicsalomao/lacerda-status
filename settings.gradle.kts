pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    maven("https://jitpack.io")
    jcenter()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    maven("https://jitpack.io")
    mavenCentral()
  }
}

rootProject.name = "Lacerda Status"

include(":app")