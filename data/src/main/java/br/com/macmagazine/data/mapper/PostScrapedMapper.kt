package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import br.com.macmagazine.domain.entity.Post
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private const val POST_HIGHLIGHTED = "Destaques"

fun List<PostScraped>.toPostList() = this.map { postScraped ->
    Post(
        guid = postScraped.guid,
        title = postScraped.title,
        description = postScraped.description,
        imageUrl = postScraped.image,
        highlighted = postScraped.categories.contains(POST_HIGHLIGHTED),
        pubDate = LocalDate.parse(postScraped.pubDate, DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss Z"))
    )
}