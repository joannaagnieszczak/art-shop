package pl.asia.artshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.asia.artshop.login.LoginScreen
import pl.asia.artshop.product.ProductScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginNavigation.route){
        composable(route = Screen.LoginNavigation.route){
            LoginScreen(navController = navController)}
            composable(route = Screen.ProductNavigation.route){
                ProductScreen()
        }
    }
}