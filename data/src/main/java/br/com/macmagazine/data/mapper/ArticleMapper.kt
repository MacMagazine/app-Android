package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import com.prof.rssparser.Article

fun List<Article>.toPostScrapedList() = this.map { article ->
    PostScraped(
        title = article.title ?: "",
        description = article.description ?: "",
        imageUrl = article.image ?: ""
    )
}