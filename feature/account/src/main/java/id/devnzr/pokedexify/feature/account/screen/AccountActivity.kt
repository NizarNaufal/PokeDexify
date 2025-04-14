package id.devnzr.pokedexify.feature.account.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.devnzr.pokedexify.core.uikit.theme.PokeDexifyTheme

class AccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexifyTheme {
                AccountHost()
            }
        }
    }
}
