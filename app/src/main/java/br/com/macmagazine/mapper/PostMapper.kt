package br.com.macmagazine.mapper

import br.com.macmagazine.domain.entity.Post
import br.com.macmagazine.model.PostUi

fun Post.toPostUi() = PostUi(
    guid = this.guid,
    title = this.title,
    description = this.description,
    imageUrl = this.imageUrl,
    highlighted = this.highlighted
)