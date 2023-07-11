package pl.asia.artshop.product

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import pl.asia.artshop.database.Product

class ProductViewModel(
    private val productUseCase: ProductUseCase
): ViewModel() {

    fun getProducts(): Flow<List<Product>> {
        return productUseCase.getProducts()
    }
}

