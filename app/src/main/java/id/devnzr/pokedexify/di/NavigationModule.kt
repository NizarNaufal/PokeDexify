package id.devnzr.pokedexify.di

import id.devnzr.nzr.pokedex.navigation.AppNavigation
import id.devnzr.pokedexify.navigation.AppNavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single<AppNavigation> { AppNavigatorImpl() }
}