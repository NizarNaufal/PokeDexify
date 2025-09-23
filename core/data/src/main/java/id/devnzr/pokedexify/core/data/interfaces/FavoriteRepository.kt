package id.devnzr.pokedexify.core.data.interfaces

import id.devnzr.pokdexify.models.result.FavoritesResult
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavorites(): Flow<List<FavoritesResult>>
    suspend fun toggleFavorite(pokemon: FavoritesResult)
    suspend fun isFavorite(id: Int): Boolean
}
