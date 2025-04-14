package id.devnzr.pokedexify.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import id.devnzr.pokedexify.core.uikit.theme.PokeDexifyTheme
import id.devnzr.pokedexify.feature.detail.screen.DetailActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeDexifyTheme{
                MainHost()
            }
        }
    }


    fun handleNavigateToDetail(name: String) {
        val activity = Intent(this, DetailActivity::class.java)
        activity.putExtra("name", name)
        startActivity(activity)
    }
}
