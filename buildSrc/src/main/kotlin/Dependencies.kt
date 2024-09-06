import org.gradle.api.JavaVersion

object Versions {
    const val core = "1.9.0"
    const val lifecycle = "2.6.2"
    const val compose = "1.8.2"
    const val composeBom = "2023.03.00"
    const val material3 = "material3"
    const val composeNavigation = "2.7.7"

    // Testing
    const val junit = "4.13.2"
    const val junitExt = "1.1.5"
    const val expresso = "3.5.1"

    // Hilt
    const val hilt = "2.44"
    const val hiltNavigation = "1.0.0"

    // Arrow
    const val arrow = "1.2.4"

    // Room
    const val room = "2.6.1"

    // Datastore preferences
    const val datastorePreferences = "1.0.0"

    // Coil
    const val coil = "2.6.0"

    // ConstraintLayout
    const val constraintLayout = "1.0.1"

    // Serializable
    const val serializable = "1.6.0"

    // Ktor
    const val ktor = "1.5.0"
}

object Libs {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val compose = "androidx.activity:activity-compose:${Versions.compose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUI = "androidx.compose.ui:ui"
    const val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:${Versions.material3}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"

    // Arrow
    const val arrow = "io.arrow-kt:arrow-core:${Versions.arrow}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // Datastore preferences
    const val datastorePreferences = "androidx.datastore:datastore-preferences:${Versions.datastorePreferences}"

    // Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    // ConstraintLayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"

    // Serializable
    const val serializable = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializable}"

    // Ktor
    const val ktor = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
}

object Config {
    const val compileSdk = 34
    const val minSdk = 33
    const val targetSdk = 34

    const val namespace = "com.testdex"
    const val applicationId = "com.testdex"
    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val jvmTarget = "17"
    val javaVersion = JavaVersion.VERSION_17

    const val kotlinCompilerExtensionVersion = "1.4.3"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val expresso = "androidx.test.espresso:espresso-core:${Versions.expresso}"
    const val composeTest = "androidx.compose.ui:ui-test-junit4"
}

object Debug {
    const val composeTooling = "androidx.compose.ui:ui-tooling"
    const val composeManifest = "androidx.compose.ui:ui-test-manifest"
}