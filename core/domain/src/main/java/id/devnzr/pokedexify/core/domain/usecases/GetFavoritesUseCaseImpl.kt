package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.FavoritesResult
import id.devnzr.pokedexify.core.data.interfaces.FavoriteRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetFavoritesUseCase
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCaseImpl(
    private val repository: FavoriteRepository
) : GetFavoritesUseCase {

    override fun invoke(): Flow<List<FavoritesResult>> =
        repository.getFavorites()
}