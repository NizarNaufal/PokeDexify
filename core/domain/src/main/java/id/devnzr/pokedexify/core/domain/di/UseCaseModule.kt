package id.devnzr.pokedexify.core.domain.di

import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonDetailUseCase
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonListUseCase
import id.devnzr.pokedexify.core.domain.interfaces.GetUserUseCase
import id.devnzr.pokedexify.core.domain.interfaces.LoginUseCase
import id.devnzr.pokedexify.core.domain.usecases.GetPokemonDetailUseCaseImpl
import id.devnzr.pokedexify.core.domain.usecases.GetPokemonListUseCaseImpl
import id.devnzr.pokedexify.core.domain.usecases.GetUserUseCaseImpl
import id.devnzr.pokedexify.core.domain.usecases.LoginUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetPokemonListUseCase> {
        GetPokemonListUseCaseImpl(get())
    }
    single<GetPokemonDetailUseCase> {
        GetPokemonDetailUseCaseImpl(get())
    }
    single<LoginUseCase> {
        LoginUseCaseImpl(get())
    }
    single<GetUserUseCase> {
        GetUserUseCaseImpl(get())
    }
}
