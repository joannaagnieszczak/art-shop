package pl.asia.artshop.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ProductsDatabaseCell(
    productViewModel: ProductViewModel = viewModel()
) {
    val products by productViewModel.getProducts().collectAsState(initial = emptyList())
    println("ASIATEST products = $products")
    LazyColumn {
        items(items = products) { product ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                shape = RoundedCornerShape(10.dp),
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = product.title, color = Color.Black)
                    Text(text = product.description, color = Color.Black)
                }
            }
        }
    }
}


