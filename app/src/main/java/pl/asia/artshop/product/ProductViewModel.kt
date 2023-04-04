package pl.asia.artshop.product

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ProductViewState(
            name = "Edith",
            price = 299.0,
            description = "New modern chair."
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