package pl.asia.artshop.product

data class ProductViewState(
    val name: String,
    val price: Double,
    val description: String,
    val isSecondButtonEnabled: Boolean = false
)
