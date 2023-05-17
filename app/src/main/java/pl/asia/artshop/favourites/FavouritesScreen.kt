package pl.asia.artshop.favourites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FavouritesScreen(){
    Box(modifier = Modifier.fillMaxSize().padding(),
        contentAlignment = Alignment.Center){
        Text(text = "Favourites Screen")}}