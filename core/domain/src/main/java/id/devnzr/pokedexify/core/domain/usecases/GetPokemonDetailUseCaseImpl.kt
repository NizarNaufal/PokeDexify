package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonDetailUseCase
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import kotlinx.coroutines.flow.Flow

class GetPokemonDetailUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : GetPokemonDetailUseCase {

    override fun invoke(id: Long): Flow<ResultState<PokemonDetailResult>> =
        UseCaseDelegate.neutralizeResultFlow {
            val response = pokemonRepository.fetchDetailPokemon(id.toString())
            ResultState.Success(
                data = response.data?.map() ?: PokemonDetailResult.empty()
            )
        }
}
