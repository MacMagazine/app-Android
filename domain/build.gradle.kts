import extensions.implementation
import dependencies.domainModuleDependencies

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner  = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(domainModuleDependencies)
}