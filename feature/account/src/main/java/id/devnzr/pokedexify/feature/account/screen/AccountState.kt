package id.devnzr.pokedexify.feature.account.screen

import id.devnzr.pokdexify.models.result.ResultState

data class AccountState(
    val isLoading: Boolean = false,
    val resultUser: ResultState<String> = ResultState.Idle()
)
