package br.com.macmagazine.ui.main.post.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import br.com.macmagazine.common.isToday
import br.com.macmagazine.common.isYesterday
import br.com.macmagazine.common.toFormattedDate
import br.com.macmagazine.mapper.toPostItemUi
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.paging.PostPagingDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class PostListViewModel(
    private val postsDataSource: PostPagingDataSource
) : ViewModel() {

    fun getPosts(): Flow<PagingData<PostUi>> {
        return postsDataSource.getPosts()
            .map { pagingData -> pagingData.map { it.toPostItemUi() } }
            .map {
                it.insertSeparators<PostUi.PostItemUi, PostUi>{ postBefore, postAfter ->
                    if (postAfter == null) {
                        // we're at the end of the list
                        return@insertSeparators null
                    }

                    if (postBefore == null) {
                        // we're at the beginning of the list
                        createDateSeparator(postAfter.pubDate)
                        return@insertSeparators createDateSeparator(postAfter.pubDate)
                    }

                    if (postAfter.pubDate.isAfter(postBefore.pubDate)) {
                        createDateSeparator(postAfter.pubDate)
                    } else {
                        null
                    }
                }
            }
            .cachedIn(viewModelScope)
    }

    private fun createDateSeparator(date: LocalDate): PostUi.PostSeparatorDateUi {
        val label = when {
            date.isToday() -> "HOJE"
            date.isYesterday() -> "ONTEM"
            else -> date.toFormattedDate().uppercase()
        }
        return PostUi.PostSeparatorDateUi(label)
    }
}