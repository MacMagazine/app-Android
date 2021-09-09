package dependencies

val dataModuleDependencies = arrayListOf<String>().apply {
    add(AppDependencies.coreKtx)
    add(AppDependencies.koinCore)
    add(AppDependencies.koinScope)
    add(AppDependencies.kotlinStdLib)
    add(AppDependencies.okhttp)
    add(AppDependencies.okhttpUrlConnection)
    add(AppDependencies.pkRss)
}