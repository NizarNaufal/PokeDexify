package id.devnzr.pokedexify.feature.favorites.screen

import id.devnzr.pokdexify.models.result.FavoritesResult

data class FavoriteState(
    val favorites: List<FavoritesResult> = emptyList(),
    val isLoading: Boolean = false
)