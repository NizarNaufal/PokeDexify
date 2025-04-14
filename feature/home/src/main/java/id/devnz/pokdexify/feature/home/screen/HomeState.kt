package id.devnz.pokdexify.feature.home.screen

import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.PokemonResult
import id.devnzr.pokdexify.models.result.ResultState

data class HomeState(
    val pokemonList: ResultState<PagingResult<PokemonResult>> = ResultState.Idle(),
    val cachedPokemonList: List<PokemonResult> = emptyList(),
    val endReached: Boolean = false,
    val isLoading: Boolean = false,
    val loadError: String = "",
    val isSearching: Boolean = false,
    val isSearchStarting: Boolean = true,
)
