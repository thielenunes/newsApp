package thielenunes.io.newsappstarter.presenter.search

import android.os.Message
import thielenunes.io.newsappstarter.model.NewsResponse
import thielenunes.io.newsappstarter.model.data.NewsDataSource
import thielenunes.io.newsappstarter.presenter.ViewHome

class SearchPresenter (val view: ViewHome.View, private val dataSource: NewsDataSource): SearchHome.Presenter {
    override fun search(term: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        TODO("Not yet implemented")
    }

    override fun onError(message: Message) {
        TODO("Not yet implemented")
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }
}