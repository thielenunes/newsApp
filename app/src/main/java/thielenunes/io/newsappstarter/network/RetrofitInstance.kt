package thielenunes.io.newsappstarter.network

import thielenunes.io.newsappstarter.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

        // by lazy -> so vai executar ela quando eu precisar
        // nao trava a aplicação
        private val retofit by lazy{

            // log para ver o que estamos recebendo
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val cliente = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            // criação do retrofit
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build()
        }

        // criação do retrofit
        val api by lazy{
            retofit.create(NewsApi::class.java)
        }
    }
}