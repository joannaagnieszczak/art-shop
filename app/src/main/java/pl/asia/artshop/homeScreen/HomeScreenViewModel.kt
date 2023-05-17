package pl.asia.artshop.homeScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenViewState(
        title = "HomeScreen"
    ))

    val uiState: StateFlow<HomeScreenViewState> = _uiState.asStateFlow()
}