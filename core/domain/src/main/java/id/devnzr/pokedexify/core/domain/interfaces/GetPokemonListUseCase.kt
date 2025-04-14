package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.PokemonResult
import id.devnzr.pokdexify.models.result.ResultState
import kotlinx.coroutines.flow.Flow

interface GetPokemonListUseCase {
    operator fun invoke(
        refreshing: Boolean,
        previous: PagingResult<PokemonResult>?,
    ): Flow<ResultState<PagingResult<PokemonResult>>>
}
