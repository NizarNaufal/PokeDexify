package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonUseCase
import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.PokemonResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCaseImpl(private val repository: PokemonRepository) :
    GetPokemonUseCase {
    override fun invoke(
        refreshing: Boolean,
        previous: PagingResult<PokemonResult>?,
    ): Flow<ResultState<PagingResult<PokemonResult>>> = UseCaseDelegate.paginateFlow(
        previous = if (refreshing) null else previous,
    ) {
        repository.fetchPokemonList()
            .toResultStateSuccess {
                it.map(
                    previousItems = if (refreshing) null else previous?.items
                )
            }
    }
}