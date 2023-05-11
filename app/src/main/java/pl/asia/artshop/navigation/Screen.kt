package pl.asia.artshop.navigation

sealed class Screen(val route: String) {
    object ProductNavigation: Screen("product_screen")
    object LoginNavigation: Screen("login_screen")
    object HomeScreenNavigation: Screen("home_screen")
    object BasketScreenNavigation: Screen("basket_screen")
    object FavouritesScreenNavigation: Screen("favourites_screen")
    object ProfileScreenNavigation: Screen("profile_screen")
    object SearchScreenNavigation: Screen("search_screen")

}