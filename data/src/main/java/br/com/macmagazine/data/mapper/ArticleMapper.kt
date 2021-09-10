package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import com.prof.rssparser.Article

fun List<Article>.toPostScrapedList() = this.map { article ->
    PostScraped(
        guid = article.guid ?: "",
        title = article.title ?: "",
        author = article.author ?: "",
        link = article.link ?: "",
        pubDate = article.pubDate ?: "",
        description = article.description ?: "",
        content = article.content ?: "",
        image = article.image ?: "",
        audio = article.audio ?: "",
        video = article.video ?: "",
        sourceName = article.sourceName ?: "",
        sourceUrl = article.sourceUrl ?: "",
        categories = article.categories
    )
}