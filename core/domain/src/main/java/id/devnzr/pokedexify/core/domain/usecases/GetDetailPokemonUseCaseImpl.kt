package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetDetailPokemonUseCase
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import kotlinx.coroutines.flow.Flow

class GetDetailPokemonUseCaseImpl(private val pokemonRepository: PokemonRepository) :
    GetDetailPokemonUseCase {
    override fun invoke(id: String): Flow<ResultState<PokemonDetailResult>> =
        UseCaseDelegate.neutralizeResultFlow {
            pokemonRepository.fetchDetailPokemon(id).toResultStateSuccess {
                it.data?.map() ?: PokemonDetailResult()
            }
        }
}