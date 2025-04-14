package id.devnz.pokdexify.feature.home.di

import id.devnz.pokdexify.feature.home.screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
