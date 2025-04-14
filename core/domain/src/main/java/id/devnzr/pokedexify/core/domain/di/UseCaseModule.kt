package id.devnzr.pokedexify.core.domain.di

import id.devnzr.pokedexify.core.domain.interfaces.GetUserUseCase
import id.devnzr.pokedexify.core.domain.usecases.GetUserUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetPokemonEvolutionChainUseCase> {
        GetPokemonEvolutionChainUseCaseImpl(get())
    }
    single<GetPokemonDetailByIdUseCase> {
        GetPokemonDetailByIdUseCaseImpl(get())
    }
    single<GetPokemonDetailByNameUseCase> {
        GetPokemonDetailByNameUseCaseImpl(get())
    }
    single<GetPokemonTypeDetailUseCase> {
        GetPokemonTypeDetailUseCaseImpl(get())
    }
    single<GetPokemonEvolutionChainUseCase> {
        GetPokemonEvolutionChainUseCaseImpl(get())
    }
    single<GetUserUseCase> {
        GetUserUseCaseImpl(get())
    }
}
