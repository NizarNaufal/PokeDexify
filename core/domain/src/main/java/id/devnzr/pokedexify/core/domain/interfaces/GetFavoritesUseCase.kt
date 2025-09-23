package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.FavoritesResult
import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {
    operator fun invoke(): Flow<List<FavoritesResult>>
}
