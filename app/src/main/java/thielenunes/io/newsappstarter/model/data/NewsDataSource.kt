package thielenunes.io.newsappstarter.model.data

import thielenunes.io.newsappstarter.network.RetrofitInstance
import thielenunes.io.newsappstarter.presenter.news.NewsHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDataSource {
    fun getBreakingNews(callback: NewsHome.Presenter) {
        // usar corotines
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getBreakingNews("br")
            if (response.isSuccessful) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }
}