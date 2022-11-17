package thielenunes.io.newsappstarter.network

import thielenunes.io.newsappstarter.model.NewsResponse
import thielenunes.io.newsappstarter.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    // vai ficar os endpoits para pegar as noticias

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "br",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apikey: String = API_KEY

    // o que  função ira devolver
    ): Response<NewsResponse>

    @GET("/v2/everything")
    suspend fun  searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apikey: String = API_KEY
    ): Response<NewsResponse>
}
