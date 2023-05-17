package pl.asia.artshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.asia.artshop.basket.BasketScreen
import pl.asia.artshop.favourites.FavouritesScreen
import pl.asia.artshop.homeScreen.HomeScreen
import pl.asia.artshop.profile.ProfileScreen
import pl.asia.artshop.search.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarData.Home.route){
        composable(route = BottomBarData.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarData.Search.route){
            SearchScreen()
        }
        composable(route = BottomBarData.Favourites.route){
            FavouritesScreen()
        }
        composable(route = BottomBarData.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarData.Basket.route){
            BasketScreen()
        }
    }
}