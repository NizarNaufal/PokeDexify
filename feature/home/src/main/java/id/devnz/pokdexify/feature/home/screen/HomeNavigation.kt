package id.devnz.pokdexify.feature.home.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.nzr.pokedex.navigation.AppNavigation
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

@Serializable
data object HomeNavigation : Screen

fun NavGraphBuilder.homeScreen() {
    composable<HomeNavigation> {
        val viewModel: HomeViewModel = koinViewModel()
        val state: HomeState by viewModel.state.collectAsStateWithLifecycle()
        val appNavigator: AppNavigation = getKoin().get()
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            viewModel.onEvent(HomeEvent.OnGetAllData)
        }

        HomeScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is HomeEvent.OnNavigateToDetail -> appNavigator.navigateToDetail(context, event.name)
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}
