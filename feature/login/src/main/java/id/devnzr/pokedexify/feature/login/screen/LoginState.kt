package id.devnzr.pokedexify.feature.login.screen

import id.devnzr.pokdexify.models.result.ResultState

data class LoginState(
    val userName: String = "",
    val password: String = "",
    val resultLogin: ResultState<String> = ResultState.Idle()
)
