package pl.asia.artshop.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        BottomBarData.Home,
        BottomBarData.Search,
        BottomBarData.Favourites,
        BottomBarData.Basket,
        BottomBarData.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {
        screens.forEach{screen -> AddItem(
            screen = screen,
            currentDestination = currentDestination,
            navController = navController as NavHostController
        )}
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarData,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = LocalContentColor.current.copy(alpha = 0.3F),
            unselectedTextColor = LocalContentColor.current.copy(alpha = 0.3F)),
        onClick = {navController.navigate(screen.route){
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
        }
    )
}