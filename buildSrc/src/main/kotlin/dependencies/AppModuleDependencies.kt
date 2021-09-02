package dependencies

val appModuleDependencies = arrayListOf<String>().apply {
    add(AppDependencies.kotlinStdLib)
    add(AppDependencies.coreKtx)
    add(AppDependencies.appcompat)
    add(AppDependencies.materialDesign)
    add(AppDependencies.constraintLayout)
}