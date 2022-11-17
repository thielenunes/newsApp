package thielenunes.io.newsappstarter.presenter.search

import android.os.Message
import thielenunes.io.newsappstarter.model.NewsResponse

interface SearchHome {
    interface Presenter{
        fun search(term: String)
        fun onSuccess(newsResponse: NewsResponse)
        fun onError(message: Message)
        fun onComplete()
    }
}