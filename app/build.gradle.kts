plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.room") version Versions.room apply false
    id("kotlinx-serialization")
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
    implementation(Libs.lifecycleViewModel)
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
    implementation(Libs.hiltNavigation)
    kapt(Libs.hiltCompiler)

    // Arrow for Either use
    implementation(Libs.arrow)

    // Room
    implementation(Libs.roomRuntime)
    annotationProcessor(Libs.roomCompiler)
    kapt(Libs.roomCompiler)

    // Datastore preferences
    implementation(Libs.datastorePreferences)

    // Coil for async images
    implementation(Libs.coil)

    // ConstraintLayout
    implementation(Libs.constraintLayout)

    // Serializable
    implementation(Libs.kotlinxSerialization)

    // Ktor
    implementation(Libs.ktorCore)
    implementation(Libs.ktorAndroid)
    implementation(Libs.ktorJson)
    implementation(Libs.ktorSerialization)
    implementation(Libs.ktorContentNegotiation)
    implementation(Libs.ktorKotlinx)
}

kapt {
    correctErrorTypes = true
}