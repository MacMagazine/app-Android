package br.com.macmagazine.data.scrap

import android.content.Context
import br.com.macmagazine.data.mapper.toPostScrapedList
import br.com.macmagazine.data.model.PostScraped
import com.prof.rssparser.Parser

class RssScraper(
    private val context: Context
) : Scraper {
    override suspend fun getPosts(): List<PostScraped> {
        val parser = Parser.Builder()
            .context(context)
            .build()

        val channel = parser.getChannel("https://macmagazine.com.br/feed?paged=0")

        return channel.articles.toPostScrapedList()
    }
}