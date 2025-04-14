package id.devnzr.pokedexify.screen.splash

import id.devnzr.pokdexify.models.result.ResultState

data class SplashState(
    val resultState: ResultState<String> = ResultState.Loading()
)
