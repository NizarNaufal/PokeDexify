package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.FavoritesResult
import id.devnzr.pokedexify.core.data.interfaces.FavoriteRepository
import id.devnzr.pokedexify.core.domain.interfaces.ToggleFavoriteUseCase

class ToggleFavoriteUseCaseImpl(
    private val repository: FavoriteRepository
) : ToggleFavoriteUseCase {

    override suspend fun invoke(pokemon: FavoritesResult) {
        repository.toggleFavorite(pokemon)
    }
}
