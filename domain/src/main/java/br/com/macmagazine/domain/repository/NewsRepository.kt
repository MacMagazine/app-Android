package br.com.macmagazine.domain.repository

import br.com.macmagazine.domain.entity.Post

interface NewsRepository {

    suspend fun getPosts(page: Int): List<Post>

}