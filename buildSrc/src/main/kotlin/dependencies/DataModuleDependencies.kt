package dependencies

val dataModuleDependencies = arrayListOf<String>().apply {
    add(AppDependencies.coreKtx)
    add(AppDependencies.koinCore)
    add(AppDependencies.koinScope)
    add(AppDependencies.kotlinStdLib)
}