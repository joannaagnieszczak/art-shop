package pl.asia.artshop.product

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.asia.artshop.R

class ProductViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ProductViewState(
            name = "Edith",
            price = "99.0 PLN",
            description = "A large ceramic pot with a texture and a matte finish, it can also act as a casing.",
            headlineDetail = "Details",
            headlineDimensions = "Dimensions",
            headlineShipping = "Shipping",
            descriptionDetail = "Material:\n" +
                    "Ceramics\n" +
                    "\n" +
                    "Description:\n" +
                    "light beige\n" +
                    "Uniform",
            descriptionDimensions = "Height: 11 cm\n" +
                    "Outer diameter: 12 cm\n" +
                    "Maximum pot diameter: 9 cm\n" +
                    "Diameter inside: 11 cm",
            descriptionShipping = "",
            imageList = listOf(
            R.drawable.flower_pot1,
            R.drawable.flower_pot2,
            R.drawable.flower_pot3
            )
        )
    )
    val uiState: StateFlow<ProductViewState> = _uiState.asStateFlow()

    fun updateProduct() {
        _uiState.update { currentState ->
            currentState.copy(name = "New test name")
        }
    }

    fun makeSecondButtonEnable() {
        _uiState.update { currentState ->
            currentState.copy(isSecondButtonEnabled = true)
        }
    }
}