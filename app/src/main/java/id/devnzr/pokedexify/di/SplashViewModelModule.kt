package id.devnzr.pokedexify.di

import id.devnzr.pokedexify.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashViewModelModule = module {
    viewModel { SplashViewModel(get()) }
}
