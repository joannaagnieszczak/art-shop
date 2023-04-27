package pl.asia.artshop.loginScreen

data class ProductViewStateLogin(
    val login: String,
    val password: String,
    val loginButton: String,
    val isSecondButtonEnabled: Boolean = false

)
