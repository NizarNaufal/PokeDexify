package id.devnzr.pokedexify.feature.login.di

import id.devnzr.pokedexify.feature.login.screen.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule = module {
    viewModel { LoginViewModel(get()) }
}