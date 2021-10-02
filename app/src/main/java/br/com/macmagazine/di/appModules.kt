package br.com.macmagazine.di

import br.com.macmagazine.common.resource.AndroidResource
import br.com.macmagazine.common.resource.ResourceProvider
import br.com.macmagazine.data.repository.NewsRepositoryImpl
import br.com.macmagazine.data.scrap.RssScraper
import br.com.macmagazine.data.scrap.Scraper
import br.com.macmagazine.domain.repository.NewsRepository
import br.com.macmagazine.paging.PostPagingDataSource
import br.com.macmagazine.ui.main.post.list.PostListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val dataModule = module {
    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }

    single<Scraper> {
        RssScraper()
    }
}

private val uiModule = module {
    single<ResourceProvider> {
       AndroidResource(get())
    }

    factory {
        PostPagingDataSource(get())
    }
}

private val viewModelModule = module {
    viewModel {
        PostListViewModel(get(), get())
    }
}

val appModules = listOf(
    dataModule,
    uiModule,
    viewModelModule
)


