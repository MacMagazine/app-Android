package br.com.macmagazine.domain.entity

import java.time.LocalDate

data class Post(
    val guid: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val highlighted: Boolean,
    val pubDate: LocalDate
)