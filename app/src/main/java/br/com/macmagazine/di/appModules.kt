package br.com.macmagazine.di

import br.com.macmagazine.ui.main.post.list.PostListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel {
        PostListViewModel()
    }
}

val appModules = listOf(viewModelModule)


