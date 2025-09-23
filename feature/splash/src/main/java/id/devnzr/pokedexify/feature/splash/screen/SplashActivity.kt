package id.devnzr.pokedexify.feature.splash.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import id.devnzr.nzr.pokedex.navigation.AppNavigation
import org.koin.android.ext.android.inject

class SplashActivity : ComponentActivity() {
    private val appNavigator: AppNavigation by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SplashHost()
            }
        }
    }

    fun navigateToLoginActivity() {
        appNavigator.navigateToLogin(this)
    }

    fun navigateToMainActivity() {
        appNavigator.navigateToMain(this)
    }
}