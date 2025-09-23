package id.devnzr.pokedexify.feature.splash.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object SplashNavigation : Screen

fun NavGraphBuilder.splashScreen() {
    composable<SplashNavigation> {
        val viewModel: SplashViewModel = koinViewModel()
        val activity = LocalContext.current as SplashActivity
        val state: SplashState by viewModel.state.collectAsStateWithLifecycle()
        LaunchedEffect(state.resultState) {
            when (state.resultState) {
                is ResultState.Success -> activity.navigateToMainActivity()
                else -> activity.navigateToLoginActivity()
            }
        }
        SplashScreen()
    }
}