package pl.asia.artshop.navigation

sealed class Screen(val route: String) {
    object ProductNavigation: Screen("product_screen")
    object LoginNavigation: Screen("login_screen")
}