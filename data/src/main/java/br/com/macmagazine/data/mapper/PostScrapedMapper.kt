package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import br.com.macmagazine.domain.entity.Post

fun List<PostScraped>.toPostList() = this.map { postScraped ->
    Post(
        title = postScraped.title,
        description = postScraped.description,
        imageUrl = postScraped.imageUrl
    )
}