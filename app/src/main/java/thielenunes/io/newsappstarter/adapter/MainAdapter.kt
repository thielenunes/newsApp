package thielenunes.io.newsappstarter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import thielenunes.io.newsappstarter.R
import thielenunes.io.newsappstarter.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ArticleViewHolder> (){

    // criar viewholder
    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){

        // ira retornar verdadeiro se os dois itens forem iguais
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.url == newItem.url
        }
        // verificar se dois itens possuem mesmo dados
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return  oldItem == newItem
        }

    }
    // configurar para usar differ
    val differ = AsyncListDiffer(this, differCallback)

    // É aqui que irá inflar a view com itens
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
             LayoutInflater.from(parent.context)
                 .inflate(R.layout.item_news, parent, false)
        )
    }


    // ira pegar o tamanho da lista
    override fun getItemCount(): Int = differ.currentList.size

    // fazer o link dos dados do nosso item e passar os dados
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        // pegar o item atraves da posição
        val article = differ.currentList[position]

        // passar os itens para a view
        holder.itemView.apply {
            // carregar a imagem
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)

            // carregar os campos de texto
            tvTitle.text = article.author ?: article.source?.name
            tvSource.text = article.source?.name ?: article.author
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt

            // pegar o click
            setOnclickListener{
                onItemClickListener?.let { click ->
                    click(article)
                }
            }
        }
    }

    // configurar o onClick do item  (Unit = não retorna nada)
    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnclickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}