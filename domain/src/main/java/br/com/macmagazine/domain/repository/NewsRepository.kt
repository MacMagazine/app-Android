package br.com.macmagazine.domain.repository

import br.com.macmagazine.domain.entity.Post

interface NewsRepository {

    fun getPosts(): List<Post>

}