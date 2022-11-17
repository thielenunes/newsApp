package thielenunes.io.newsappstarter.presenter.news

import thielenunes.io.newsappstarter.model.NewsResponse
import thielenunes.io.newsappstarter.model.data.NewsDataSource
import thielenunes.io.newsappstarter.presenter.ViewHome

// Agora a view consegue fazer uma requisição para o banco presenter que vai ate o banco e retorna os valores

class NewsPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : NewsHome.Presenter {
    override fun requestAll() {
        // abrir progress bar
        this.view.showProgressBar()
        // chamar datasource e pedir as noticias
        this.dataSource.getBreakingNews(this)

    }

    override fun onSuccess(newsResponse: NewsResponse) {
        // vai mandar para a view
        this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
        // enviar erro para a view
        this.view.showFailure(message)
    }

    override fun onComplete() {
        // esconder a progressBar
        this.view.hideProgressBar()
    }
}