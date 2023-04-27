package pl.asia.artshop.loginScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductViewModelLogin : ViewModel() {
    private val _uiState = MutableStateFlow(
        ProductViewStateLogin(
            login = "Login",
            password = "Password",
            loginButton = "Log in"

        )
    )



    val uiState: StateFlow<ProductViewStateLogin> = _uiState.asStateFlow()

    fun updateProduct() {
        _uiState.update { currentState ->
            currentState.copy(login = "New test name")
        }
    }

    fun makeSecondButtonEnable() {
        _uiState.update { currentState ->
            currentState.copy(isSecondButtonEnabled = true)
        }
    }
}