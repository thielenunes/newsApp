package thielenunes.io.newsappstarter.presenter.favorite

import thielenunes.io.newsappstarter.model.Article

interface FavoriteHome {
    fun showArticles(article: List<Article>)
}