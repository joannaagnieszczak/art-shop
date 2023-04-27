package pl.asia.artshop.login

data class LoginViewState(
    val login: String = "",
    val password: String = "",
    val isLoginButtonEnabled: Boolean = false
)
