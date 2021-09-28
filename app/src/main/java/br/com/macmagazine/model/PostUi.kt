package br.com.macmagazine.model

import java.time.LocalDate

sealed class PostUi {
    data class PostItemUi(
        val guid: String,
        val title: String,
        val description: String,
        val imageUrl: String,
        val highlighted: Boolean,
        val pubDate: LocalDate
    ) : PostUi()

    data class PostSeparatorDateUi(
        val description: String
    ) : PostUi()
}