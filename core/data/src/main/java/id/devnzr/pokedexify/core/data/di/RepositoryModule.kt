package id.devnzr.pokedexify.core.data.di

import id.devnzr.pokedexify.core.data.interfaces.AuthRepository
import id.devnzr.pokedexify.core.data.interfaces.FavoriteRepository
import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository
import id.devnzr.pokedexify.core.data.repositories.AuthRepositoryImpl
import id.devnzr.pokedexify.core.data.repositories.FavoriteRepositoryImpl
import id.devnzr.pokedexify.core.data.repositories.PokemonRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonRepository> {
        PokemonRepositoryImpl(get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }
    single<FavoriteRepository> {
        FavoriteRepositoryImpl(get())
    }
}
