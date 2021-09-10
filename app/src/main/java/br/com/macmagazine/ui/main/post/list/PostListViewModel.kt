package br.com.macmagazine.ui.main.post.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import br.com.macmagazine.mapper.toPostUi
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.paging.PostPagingDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostListViewModel(
    private val postsDataSource: PostPagingDataSource
) : ViewModel() {

    fun getPosts(): Flow<PagingData<PostUi>> {
        return postsDataSource.getPosts()
            .map { pagingData ->
                pagingData.map { it.toPostUi() }
            }
            .cachedIn(viewModelScope)
    }
}