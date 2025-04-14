package id.devnz.pokdexify.feature.home.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object HomeNavigation : Screen

fun NavGraphBuilder.homeScreen(onNavigateDetail: (String) -> Unit) {
    composable<HomeNavigation> {
        val viewModel: HomeViewModel = koinViewModel()
        val state: HomeState by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            viewModel.onEvent(HomeEvent.OnGetAllData)
        }

        HomeScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is HomeEvent.OnNavigateToDetail -> onNavigateDetail(event.name)
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}
