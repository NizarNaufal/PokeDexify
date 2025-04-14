package id.devnzr.pokedexify.feature.detail.screen

import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.ResultState

data class DetailState(
    val isLoading: Boolean = false,
    val resultPokemonData: ResultState<PokemonDetailResult> = ResultState.Idle()
)
