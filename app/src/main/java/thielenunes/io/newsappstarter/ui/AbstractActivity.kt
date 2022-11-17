package thielenunes.io.newsappstarter.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

// classe abstrata para economizar codigo ja que todas as acticity tem metodo onCreate, getLayout e
// ira enjetar os valores recebidos

abstract class AbstractActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        onInject()
    }
    // criar dois metodos abstratos

    // getlayout -> pegar cada layout correspondente da Activity
    @LayoutRes
    protected abstract fun getLayout() : Int

    // onInject -> ira injetar as dependencias
    protected abstract fun onInject()
}