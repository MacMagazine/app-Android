object AppDependencies {
    // date
    const val androidDesugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

    // dependency injection
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val koinScope = "io.insert-koin:koin-android:${Versions.koin_version}"

    // navigation component
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    // pagination
    const val paging = "androidx.paging:paging-runtime:${Versions.paging_version}"

    // rss
    const val rssParser = "com.prof18.rssparser:rssparser:3.1.5"

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
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
}