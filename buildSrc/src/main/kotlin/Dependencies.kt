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

    // Arrow
    const val arrow = "1.2.4"

    // Retrofit
    const val retrofit = "2.9.0"
}

object Libs {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
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

    // Arrow
    const val arrow = "io.arrow-kt:arrow-core:${Versions.arrow}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitCoverter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
}

object Config {
    const val compileSdk = 34
    const val minSdk = 33
    const val targetSdk = 34

    const val namespace = "com.testdex"
    const val applicationId = "com.testdex"
    const val versionName = "1.0"

    const val jvmTarget = "17"
    val javaVersion = JavaVersion.VERSION_17
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