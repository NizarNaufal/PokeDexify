package id.devnzr.pokedexify.core.data.repositories

import id.devnzr.pokdexify.models.result.FavoritesResult
import id.devnzr.pokedexify.core.data.interfaces.FavoriteRepository
import id.devnzr.pokedexify.database.dao.FavoritePokemonDao
import id.devnzr.pokedexify.database.entities.toEntity
import id.devnzr.pokedexify.database.entities.toResultList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(private val dao: FavoritePokemonDao): FavoriteRepository {
    override fun getFavorites(): Flow<List<FavoritesResult>> = dao.getAllFavorites().map { entities -> entities.toResultList() }

    override suspend fun toggleFavorite(pokemon: FavoritesResult) {
        val results = pokemon.toEntity()
        if (dao.isFavorite(results.id)) {
            dao.deleteFavorite(results)
        } else {
            dao.insertFavorite(results)
        }
    }

    override suspend fun isFavorite(id: Int): Boolean = dao.isFavorite(id)
}