package id.devnzr.pokedexify.feature.login.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object LoginNavigation : Screen

fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable<LoginNavigation> {
        val viewModel: LoginViewModel = koinViewModel()
        val state: LoginState by viewModel.state.collectAsStateWithLifecycle()
        val activity = LocalContext.current as LoginActivity
        LaunchedEffect(state.resultLogin) {
            if (state.resultLogin is ResultState.Success){
                activity.handleToMainActivity()
            }
        }

        LoginScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is LoginEvent.OnNavigateBack -> {
                        navController.popBackStack()
                    }
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}
