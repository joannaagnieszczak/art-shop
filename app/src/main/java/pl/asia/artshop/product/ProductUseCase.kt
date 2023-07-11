package pl.asia.artshop.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.asia.artshop.database.Product

class ProductUseCase(
    private val productRepository: ProductRepository
) {

    fun getProducts(): Flow<List<Product>> {
        return productRepository.getProducts().map { products ->
            products.filter { product ->
                product.title.contains("Chair")
            }
        }
    }

}