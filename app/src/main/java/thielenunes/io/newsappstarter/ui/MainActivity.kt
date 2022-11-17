package thielenunes.io.newsappstarter.ui

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import thielenunes.io.newsappstarter.R
import thielenunes.io.newsappstarter.adapter.MainAdapter
import thielenunes.io.newsappstarter.model.Article
import thielenunes.io.newsappstarter.model.data.NewsDataSource
import thielenunes.io.newsappstarter.presenter.ViewHome
import thielenunes.io.newsappstarter.presenter.news.NewsPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(), ViewHome.View {
    override fun getLayout(): Int = R.layout.activity_main
    // by lazy inicializacao
    // colocar adapter para pegar intes que vem da requisição e configurar recyclerView
    private val mainAdapter by lazy{
        MainAdapter()
    }

    // lateinit inicializacao atrasada
    // Adicionar o Presenter
    private lateinit var presenter: NewsPresenter

    override fun onInject() {
        val dataSource = NewsDataSource()
        // this = View
        presenter = NewsPresenter(this, dataSource)
        //view pede para preseter os dados
        presenter.requestAll()
        configRecycler()
    }

    // funcao para configurar a reciclerview
    private fun configRecycler(){
        with(rvNews){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity, DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun showProgressBar() {
    rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE

    }

    override fun showArticles(article: List<Article>) {
    mainAdapter.differ.submitList(article.toList())
    }

}