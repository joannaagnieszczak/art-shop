package pl.asia.artshop.login


/*@OptIn(ExperimentalMaterial3Api::class)
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
}*/


