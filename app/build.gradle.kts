plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.room") version Versions.room apply false
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
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

    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofitCoverter)

    // Room
    implementation(Libs.roomRuntime)
    annotationProcessor(Libs.roomCompiler)
    kapt(Libs.roomCompiler)
}

kapt {
    correctErrorTypes = true
}