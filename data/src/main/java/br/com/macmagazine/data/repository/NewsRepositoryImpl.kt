package br.com.macmagazine.data.repository

import br.com.macmagazine.data.mapper.toPostList
import br.com.macmagazine.data.scrap.Scraper
import br.com.macmagazine.domain.entity.Post
import br.com.macmagazine.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val scraper: Scraper
) : NewsRepository {
    override suspend fun getPosts(page: Int): List<Post> = scraper.getPosts(page).toPostList()
}