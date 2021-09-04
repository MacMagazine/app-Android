object AppDependencies {
    // dependency injection
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val koinScope = "io.insert-koin:koin-android:${Versions.koin_version}"

    // navigation component
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    // std lib
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // ui
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}