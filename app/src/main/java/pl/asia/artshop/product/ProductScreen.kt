package pl.asia.artshop.product

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()) {
    val productUiState by productViewModel.uiState.collectAsState()
    Column() {
        Text(text = productUiState.name)
        Text(text = productUiState.price.toString())
        Text(text = productUiState.description)

        Button(
            onClick = {productViewModel.makeSecondButtonEnable()}) {
            (Text(text = "First button"))
        }

        Button(
            enabled = productUiState.isSecondButtonEnabled,
            onClick = {productViewModel.updateProduct()}) {
            (Text(text = "Update product"))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}