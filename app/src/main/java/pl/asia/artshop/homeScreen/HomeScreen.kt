package pl.asia.artshop.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel = viewModel()){
    val homeScreenUiState by homeScreenViewModel.uiState.collectAsState()
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Text(text = homeScreenUiState.title)
    }
}

