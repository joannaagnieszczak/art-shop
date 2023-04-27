package pl.asia.artshop.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginViewState())

    val uiState: StateFlow<LoginViewState> = _uiState.asStateFlow()

    fun onEnterLogin(login: String) {
        _uiState.update { currentState ->
            currentState.copy(
                login = login,
                isLoginButtonEnabled = login.isNotEmpty() && currentState.password.isNotEmpty())
        }
    }

    fun onEnterPassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(
                password = password,
                isLoginButtonEnabled = password.isNotEmpty() && currentState.login.isNotEmpty())
        }

    }
}