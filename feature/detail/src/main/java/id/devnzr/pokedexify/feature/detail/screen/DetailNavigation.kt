package id.devnzr.pokedexify.feature.detail.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object DetailNavigation : Screen

fun NavGraphBuilder.detailScreen(navController: NavController) {
    composable<DetailNavigation> {
        val viewModel: DetailViewModel = koinViewModel()
        val state: DetailState by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = true, block = {
            viewModel.onEvent(DetailEvent.OnGetDetail(id = it.id))
        })

        DetailScreen(
            state = state,
            onEvent = { event ->
                when(event) {
                    DetailEvent.OnNavigateBack -> navController.popBackStack()
                }
            }
        )
    }
}
