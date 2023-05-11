package pl.asia.artshop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.asia.artshop.basket.BasketScreen
import pl.asia.artshop.favourites.FavouritesScreen
import pl.asia.artshop.login.LoginScreen
import pl.asia.artshop.profile.ProfileScreen
import pl.asia.artshop.search.SearchScreen


@Composable
fun Navigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginNavigation.route){
        composable(route = Screen.LoginNavigation.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.HomeScreenNavigation.route){
            MyApp()
        }
        composable(route = Screen.SearchScreenNavigation.route){
            SearchScreen()
        }
        composable(route = Screen.FavouritesScreenNavigation.route){
            FavouritesScreen()
        }
        composable(route = Screen.BasketScreenNavigation.route){
            BasketScreen()
        }
        composable(route = Screen.ProfileScreenNavigation.route){
            ProfileScreen()
        }
    }

}