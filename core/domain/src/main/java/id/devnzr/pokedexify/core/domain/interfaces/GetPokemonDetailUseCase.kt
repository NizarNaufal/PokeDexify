package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.ResultState
import kotlinx.coroutines.flow.Flow

interface GetPokemonDetailUseCase {
    operator fun invoke(id: String): Flow<ResultState<PokemonDetailResult>>
}
