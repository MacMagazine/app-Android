package br.com.macmagazine.data.model

data class PostScraped(
    val guid: String,
    val title: String,
    val author: String,
    val link: String,
    val pubDate: String,
    val description: String,
    val content: String,
    val image: String,
    val audio: String,
    val video: String,
    val sourceName: String,
    val sourceUrl: String,
    val categories: MutableList<String>
)