package thielenunes.io.newsappstarter.model

import java.io.Serializable

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?

    // para poder passar esse objeto para outra activity usar Serializable
):Serializable