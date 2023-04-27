package pl.asia.artshop.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        LoginViewState(
            login = "Login",
            password = "Password",
            loginButton = "Log in"

        )
    )



    val uiState: StateFlow<LoginViewState> = _uiState.asStateFlow()

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