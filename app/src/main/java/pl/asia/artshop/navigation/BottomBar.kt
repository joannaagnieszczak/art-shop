package pl.asia.artshop.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pl.asia.artshop.homeScreen.HomeScreen
import pl.asia.artshop.ui.theme.ArtshopTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    ArtshopTheme {
        val navController = rememberNavController()
        Scaffold(bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomBarData(
                        name = "Home",
                        route = Screen.HomeScreenNavigation.route,
                        icon = Icons.Default.Home
                    ),
                    BottomBarData(
                        name = "Search",
                        route = Screen.SearchScreenNavigation.route,
                        icon = Icons.Default.Search
                    ),
                    BottomBarData(
                        name = "Favourites",
                        route = Screen.FavouritesScreenNavigation.route,
                        icon = Icons.Default.Favorite
                    ),
                    BottomBarData(
                        name = "Basket",
                        route = Screen.BasketScreenNavigation.route,
                        icon = Icons.Default.ShoppingBasket
                    ),
                    BottomBarData(
                        name = "Profile",
                        route = Screen.ProfileScreenNavigation.route,
                        icon = Icons.Default.Person
                    ),
            ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }){padding ->
            HomeScreen(Modifier.padding(padding))
        }
        
    }
}

@Composable
fun BottomNavigationBar(items: List<BottomBarData>,
                        navController: NavController,
                        modifier: Modifier = Modifier,
                        onItemClick: (BottomBarData) -> Unit){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier,
        backgroundColor = Color.White,
        elevation = 10.dp) {
        items.forEach{ item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                    }
                    if (selected){
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 1.sp)
                    }
                })}
    }
}