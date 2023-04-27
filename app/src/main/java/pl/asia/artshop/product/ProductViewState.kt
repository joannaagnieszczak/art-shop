package pl.asia.artshop.product

data class ProductViewState(
    val name: String,
    val price: String,
    val description: String,
    val headlineDetail: String,
    val descriptionDetail: String,
    val headlineDimensions: String,
    val descriptionDimensions: String,
    val headlineShipping: String,
    val descriptionShipping: String,
    val imageList: List<Int>,
    val details: List<ProductViewModel.StringPair>,
    val isSecondButtonEnabled: Boolean = false
)
