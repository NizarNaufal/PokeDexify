package id.devnzr.pokedexify.feature.splash.screen

import id.devnzr.pokdexify.models.result.ResultState

data class SplashState(
    val resultState: ResultState<String> = ResultState.Loading()
)