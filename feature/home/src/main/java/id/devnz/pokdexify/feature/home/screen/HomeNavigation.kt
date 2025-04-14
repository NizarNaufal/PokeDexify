package id.devnz.pokdexify.feature.home.screen

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object HomeNavigation : Screen

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<HomeNavigation> {
        val viewModel: HomeViewModel = koinViewModel()
        val state: HomeState by viewModel.state.collectAsStateWithLifecycle()

        HomeScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is HomeEvent.OnNavigateToDetail -> {
//                        navController.navigate(
//                            DetailNavigation, navOptions = NavOptions.Builder().build()
//                        )
                    }
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}
