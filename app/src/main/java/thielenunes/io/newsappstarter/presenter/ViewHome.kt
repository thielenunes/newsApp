package thielenunes.io.newsappstarter.presenter

import thielenunes.io.newsappstarter.model.Article

interface ViewHome {

    // sera uma interface que ira ficar ligada direta a view
    interface View{
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showArticles(article: List<Article>)
    }
}