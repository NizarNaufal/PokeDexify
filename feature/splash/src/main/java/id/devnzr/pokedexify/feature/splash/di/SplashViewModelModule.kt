package id.devnzr.pokedexify.feature.splash.di

import id.devnzr.pokedexify.feature.splash.screen.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashViewModelModule = module {
    viewModel { SplashViewModel(get()) }
}
