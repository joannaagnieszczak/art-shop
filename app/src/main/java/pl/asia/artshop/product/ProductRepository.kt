package pl.asia.artshop.product

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import pl.asia.artshop.database.Product
import pl.asia.artshop.database.ProductDao
import pl.asia.artshop.database.ProductDb


class ProductRepository (context: Context): ProductDao {
    private val dao = ProductDb.getInstance(context).productDao()
    override suspend fun addProduct(product: Product) = withContext(Dispatchers.IO) {
        dao.addProduct(product)
    }

    override suspend fun deleteProduct(product: Product) = withContext(Dispatchers.IO) {
        dao.deleteProduct(product)
    }

    override suspend fun updateProduct(product: Product) = withContext(Dispatchers.IO) {
        dao.updateProduct(product)
    }

    override fun getProducts(): Flow<List<Product>> {
        return dao.getProducts()
    }

    override suspend fun getProduct(id: Int): Product {
        return dao.getProduct(id)
    }
}