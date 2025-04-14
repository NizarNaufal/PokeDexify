package id.devnzr.pokedexify.feature.detail.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.devnzr.pokedexify.core.uikit.theme.PokeDexifyTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexifyTheme {
                DetailHost()
            }
        }
    }
}
