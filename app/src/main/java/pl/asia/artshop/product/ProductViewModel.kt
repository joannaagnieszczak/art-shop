package pl.asia.artshop.product

import androidx.annotation.StringRes
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
            headlineShipping = "Shipping & Returns",
            descriptionDetail = "Material:\n" + "Ceramics\n" + "\n" + "Description:\n" + "light beige\n" + "Uniform",
            descriptionDimensions = "Height: 11 cm\n" + "Outer diameter: 12 cm\n" + "Maximum pot diameter: 9 cm\n" + "Diameter inside: 11 cm",
            descriptionShipping = "Delivery by standard courier\n" +
                    "We send parcels by DPD courier. Standard shipping will take 3-5 business days to reach you. You can pay for your order online or choose cash on delivery. Orders worth over PLN 200 are sent free of charge (also cash on delivery). After the order is shipped, the number of the waybill, which allows you to add shipments.\n" +
                    "The courier will be included in the order. After two failed delivery attempts, it is sent back to the online store.\n" + "\n" +
                    "Shipping to a parcel locker\n" +
                    "We send parcels to parcel lockers via InPost. The parcel will reach you within 3-5 working days. Delivery cost up to PLN 9.99 (including VAT). To parcel lockers that send only one item that has been previously paid for by online transfer. Orders worth over PLN 200 are shipped free of charge. After the order is shipped, the number of the waybill, which allows you to add shipments.\n",
            imageList = listOf(
            R.drawable.flower_pot1,
            R.drawable.flower_pot2,
            R.drawable.flower_pot3
            ),
            details = listOf(
                R.string.details to R.string.description_details,
                R.string.dimensions to R.string.description_dimensions,
                R.string.shipping_returns to R.string.description_shipping).map { StringPair(it.first, it.second) }


            )
        )

    data class StringPair(
        @StringRes val text: Int,
        @StringRes val textA: Int
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