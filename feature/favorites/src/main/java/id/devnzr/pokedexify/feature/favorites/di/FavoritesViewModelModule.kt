package id.devnzr.pokedexify.feature.favorites.di

import id.devnzr.pokedexify.feature.favorites.screen.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritesViewModelModule = module {
    viewModel { FavoriteViewModel(get(), get()) }
}
