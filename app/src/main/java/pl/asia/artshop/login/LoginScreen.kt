package pl.asia.artshop.login
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.asia.artshop.ui.theme.Typography


@Composable
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = viewModel()) {
    val productUiState by loginViewModel.uiState.collectAsState()
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = "",
            onValueChange = { },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.primary),
            placeholder = {
                Text(productUiState.login,
                    style = Typography.titleLarge,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 46.dp)
                .padding(16.dp)

        )

        TextField(
            value = "",
            onValueChange = { readLine() },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.primary),
            placeholder = {
                Text(productUiState.password,
                    style = Typography.titleLarge,
                    fontSize = 14.sp,
                    color = Color.Black)
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(16.dp)

        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
            modifier = Modifier.padding(16.dp)) {
            Text(text = productUiState.loginButton)

        }
        }
    }




@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    LoginScreen()
}