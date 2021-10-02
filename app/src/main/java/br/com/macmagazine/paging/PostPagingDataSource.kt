package br.com.macmagazine.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.macmagazine.domain.entity.Post
import br.com.macmagazine.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

private const val POST_PAGE_SIZE = 18

class PostPagingDataSource(
    private val repository: NewsRepository
) {

    private lateinit var postPagingSource: PostPagingSource

    fun getPosts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = POST_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostPagingSource(repository).also {
                    postPagingSource = it
                }
            }
        ).flow
    }

    fun invalidate() {
        postPagingSource.invalidate()
    }
}