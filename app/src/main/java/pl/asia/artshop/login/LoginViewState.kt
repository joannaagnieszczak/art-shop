package pl.asia.artshop.login

data class LoginViewState(
    val login: String,
    val password: String,
    val loginButton: String,
    val isSecondButtonEnabled: Boolean = false

)
