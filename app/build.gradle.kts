import dependencies.androidTestDependencies
import dependencies.appModuleDependencies
import dependencies.testDependencies
import extensions.implementation
import extensions.testImplementation
import extensions.androidTestImplementation

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "br.com.macmagazine"
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    coreLibraryDesugaring(AppDependencies.androidDesugaring)

    implementation(appModuleDependencies)

    annotationProcessor(AppDependencies.glideCompiler)

    testImplementation(testDependencies)

    androidTestImplementation(androidTestDependencies)
}