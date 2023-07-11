package pl.asia.artshop.product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.Flow
import pl.asia.artshop.database.Product

class ProductViewModel(app: Application): AndroidViewModel(app) {
    private val repo = ProductRepository(app.applicationContext)

    fun getProducts(): Flow<List<Product>> {
        return repo.getProducts()
    }
}

