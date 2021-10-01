package br.com.macmagazine.data.mapper

import br.com.macmagazine.data.model.PostScraped
import br.com.macmagazine.domain.entity.Post
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

private const val DATE_PATTERN = "E, dd MMM yyyy HH:mm:ss Z"
private const val POST_HIGHLIGHTED = "Destaques"
private const val ZONE_ID_BRAZIL_SP = "America/Sao_Paulo"

fun List<PostScraped>.toPostList() = this.map { postScraped ->
    val pubDateZonedTime = ZonedDateTime
        .parse(postScraped.pubDate, DateTimeFormatter.ofPattern(DATE_PATTERN))
        .withZoneSameInstant(ZoneId.of(ZONE_ID_BRAZIL_SP))

    Post(
        guid = postScraped.guid,
        title = postScraped.title,
        description = postScraped.description,
        imageUrl = postScraped.image,
        highlighted = postScraped.categories.contains(POST_HIGHLIGHTED),
        pubDate = pubDateZonedTime.toLocalDate()
    )
}