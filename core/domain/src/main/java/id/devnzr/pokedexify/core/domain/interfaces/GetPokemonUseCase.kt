package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.PokemonResults
import id.devnzr.pokdexify.models.result.ResultState
import kotlinx.coroutines.flow.Flow

interface GetPokemonUseCase {
    operator fun invoke(
        refreshing: Boolean,
        previous: PagingResult<PokemonResults>?,
    ): Flow<ResultState<PagingResult<PokemonResults>>>
}
