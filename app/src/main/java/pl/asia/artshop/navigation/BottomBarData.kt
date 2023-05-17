package pl.asia.artshop.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarData(
    val route: String,
    val title: String,
    val icon:ImageVector
){
    object Home: BottomBarData(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search: BottomBarData(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Favourites: BottomBarData(
        route = "favourite",
        title = "Favourite",
        icon = Icons.Default.Favorite
    )

    object Profile: BottomBarData(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Basket: BottomBarData(
        route = "basket",
        title = "Basket",
        icon = Icons.Default.ShoppingBasket
    )


}
