package id.devnzr.pokedexify.feature.favorites.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.pokedexify.core.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object FavoriteNavigation : Screen

fun NavGraphBuilder.favoriteScreen() {
    composable<FavoriteNavigation> {
        val viewModel: FavoriteViewModel = koinViewModel()
        val state by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            viewModel.onEvent(FavoriteEvent.OnGetFavorites)
        }

        FavoriteScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}
