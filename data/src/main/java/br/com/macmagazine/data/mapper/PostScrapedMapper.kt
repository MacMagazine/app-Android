package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import br.com.macmagazine.domain.entity.Post

private const val POST_HIGHLIGHTED = "Destaques"

fun List<PostScraped>.toPostList() = this.map { postScraped ->
    Post(
        guid = postScraped.guid,
        title = postScraped.title,
        description = postScraped.description,
        imageUrl = postScraped.image,
        highlighted = postScraped.categories.contains(POST_HIGHLIGHTED)
    )
}