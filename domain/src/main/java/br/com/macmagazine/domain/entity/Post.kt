package br.com.macmagazine.domain.entity

data class Post(
    val title: String,
    val description: String,
    val imageUrl: String,
    val highlighted: Boolean
)