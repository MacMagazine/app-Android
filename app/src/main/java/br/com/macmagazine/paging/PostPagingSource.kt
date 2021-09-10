package br.com.macmagazine.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.macmagazine.domain.entity.Post
import br.com.macmagazine.domain.repository.NewsRepository

private const val POST_STARTING_PAGE_INDEX = 1

class PostPagingSource(
    private val repository: NewsRepository
) : PagingSource<Int, Post>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val currentPageIndex = params.key ?: POST_STARTING_PAGE_INDEX

        return try {
            val posts = repository.getPosts(currentPageIndex)

            val prevKey = if (currentPageIndex == POST_STARTING_PAGE_INDEX) {
                null
            } else {
                currentPageIndex.minus(1)
            }

            val nextKey = if (posts.isEmpty()) {
                null
            } else {
                currentPageIndex.plus(1)
            }

            LoadResult.Page(
                data = posts,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}