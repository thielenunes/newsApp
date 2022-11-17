package thielenunes.io.newsappstarter.model

import thielenunes.io.newsappstarter.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)

