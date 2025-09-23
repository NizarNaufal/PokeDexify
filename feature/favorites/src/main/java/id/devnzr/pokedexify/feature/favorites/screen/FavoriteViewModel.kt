package id.devnzr.pokedexify.feature.favorites.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokdexify.models.result.FavoritesResult
import id.devnzr.pokedexify.core.domain.interfaces.GetFavoritesUseCase
import id.devnzr.pokedexify.core.domain.interfaces.ToggleFavoriteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteState())
    val state = _state.asStateFlow()

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.OnGetFavorites -> getFavorites()
            is FavoriteEvent.OnToggleFavorite -> toggleFavorite(event.pokemon)
        }
    }

    private fun getFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase()
                .collect { results ->
                    _state.update { it.copy(favorites = results) }
                }
        }
    }

    private fun toggleFavorite(pokemon: FavoritesResult) {
        viewModelScope.launch {
            toggleFavoriteUseCase(pokemon)
        }
    }
}
