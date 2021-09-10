package br.com.macmagazine.data.scrap

import android.content.Context
import br.com.macmagazine.data.mapper.toPostScrapedList
import br.com.macmagazine.data.model.PostScraped
import com.prof.rssparser.Parser

class RssScraper(
    private val context: Context
) : Scraper {
    override suspend fun getPosts(page: Int): List<PostScraped> {
        val parser = Parser.Builder()
            .context(context)
            .build()

        val channel = parser.getChannel("https://macmagazine.com.br/feed/?paged=$page")

        return channel.articles.toPostScrapedList()
    }
}