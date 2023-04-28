package pl.asia.artshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pl.asia.artshop.navigation.Navigation
import pl.asia.artshop.ui.theme.ArtshopTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtshopTheme {
                Navigation()
            }
        }
    }
}

