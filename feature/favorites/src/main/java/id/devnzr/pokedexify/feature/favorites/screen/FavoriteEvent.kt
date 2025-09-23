package id.devnzr.pokedexify.feature.favorites.screen

import id.devnzr.pokdexify.models.result.FavoritesResult

sealed class FavoriteEvent {
    data object OnGetFavorites : FavoriteEvent()
    data class OnToggleFavorite(val pokemon: FavoritesResult) : FavoriteEvent()
}