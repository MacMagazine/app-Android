package br.com.macmagazine.mapper

import br.com.macmagazine.domain.entity.Post
import br.com.macmagazine.model.PostUi

fun Post.toPostUi() = PostUi(
    title = this.title,
    description = this.description,
    imageUrl = this.imageUrl
)