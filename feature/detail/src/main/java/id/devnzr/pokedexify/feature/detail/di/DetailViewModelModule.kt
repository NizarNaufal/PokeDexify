package id.devnzr.pokedexify.feature.detail.di

import id.devnzr.pokedexify.feature.detail.screen.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailViewModelModule = module {
    viewModel { DetailViewModel(get()) }
}
