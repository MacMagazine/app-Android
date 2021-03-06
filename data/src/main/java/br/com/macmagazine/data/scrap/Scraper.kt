package br.com.macmagazine.data.scrap

import br.com.macmagazine.data.model.PostScraped

interface Scraper {

    suspend fun getPosts(page: Int): List<PostScraped>

}