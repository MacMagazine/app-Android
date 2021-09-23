package br.com.macmagazine.model

data class PostUi(
    val guid: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val highlighted: Boolean
)