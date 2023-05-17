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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pl.asia.artshop.navigation.Graph
import pl.asia.artshop.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = viewModel(), navController: NavController) {
    val loginUiState by loginViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var login by remember { mutableStateOf(loginUiState.login) }
        TextField(
            textStyle = Typography.titleLarge,
            singleLine = true,
            value = login,
            onValueChange = {
                login = it
                loginViewModel.onEnterLogin(login = it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.primary),
            placeholder = {
                Text(
                    text = "Login",
                    style = Typography.titleLarge,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 46.dp)
                .padding(16.dp)

        )
        var password by remember { mutableStateOf(loginUiState.password) }
        var passwordVisible by remember { mutableStateOf(false) }
        TextField(
            textStyle = Typography.titleLarge,
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description) }},
            value = password,
            onValueChange = {
                password = it
                loginViewModel.onEnterPassword(password = it)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.primary),
            placeholder = {
                Text(
                    text = "Password",
                    style = Typography.titleLarge,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 46.dp)
                .padding(16.dp)

        )

        Button(
            onClick = {navController.navigate(route = Graph.HOME)},
            enabled = loginUiState.isLoginButtonEnabled,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Log in")

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun LoginScreenPreview(){
    LoginScreen(navController = rememberNavController())
}


