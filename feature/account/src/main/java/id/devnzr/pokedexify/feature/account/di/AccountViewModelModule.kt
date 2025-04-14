package id.devnzr.pokedexify.feature.account.di

import id.devnzr.pokedexify.feature.account.screen.AccountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountViewModelModule = module {
    viewModel { AccountViewModel(get()) }
}
