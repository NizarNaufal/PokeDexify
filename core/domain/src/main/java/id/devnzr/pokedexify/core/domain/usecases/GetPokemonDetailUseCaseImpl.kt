package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.mapper.toDomain
import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonDetailUseCase
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import id.devnzr.pokedexify.core.domain.utils.toResultStateError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPokemonDetailUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : GetPokemonDetailUseCase {
    override fun invoke(id: String): Flow<ResultState<PokemonDetailResult>> = flow {
        emit(ResultState.Loading())
        runCatching {
            pokemonRepository.fetchDetailPokemon(name = id)
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.toDomain()))
        }.onFailure { throwable ->
            throwable.toResultStateError<String>()
        }
    }
}
