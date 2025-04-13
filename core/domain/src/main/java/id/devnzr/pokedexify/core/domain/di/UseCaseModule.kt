package id.devnzr.pokedexify.core.domain.di

import id.devnzr.pokedexify.core.domain.interfaces.GetDetailPokemonUseCase
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonUseCase
import id.devnzr.pokedexify.core.domain.usecases.GetDetailPokemonUseCaseImpl
import id.devnzr.pokedexify.core.domain.usecases.GetPokemonListUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetDetailPokemonUseCase> {
        GetDetailPokemonUseCaseImpl(get())
    }
    single<GetPokemonUseCase> {
        GetPokemonListUseCaseImpl(get())
    }
}