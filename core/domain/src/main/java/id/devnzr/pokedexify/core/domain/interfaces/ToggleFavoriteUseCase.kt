package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.FavoritesResult

interface ToggleFavoriteUseCase {
    suspend operator fun invoke(pokemon: FavoritesResult)
}
