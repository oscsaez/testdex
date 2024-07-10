plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libs.core)
    implementation(Libs.lifecycle)
    implementation(Libs.compose)
    implementation(platform(Libs.composeBom))
    implementation(Libs.composeUI)
    implementation(Libs.composeUIGraphics)
    implementation(Libs.composePreview)
    implementation(Libs.material3)
    testImplementation(Test.junit)
    androidTestImplementation(Test.junitExt)
    androidTestImplementation(Test.expresso)
    androidTestImplementation(platform(Libs.composeBom))
    androidTestImplementation(Test.composeTest)
    debugImplementation(Debug.composeTooling)
    debugImplementation(Debug.composeManifest)

    implementation(Libs.composeNavigation)

    // Hilt
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)

    // Arrow for Either use
    runtimeOnly(Libs.arrow)
}

kapt {
    correctErrorTypes = true
}