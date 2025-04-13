package id.devnzr.pokedexify.core.data.di

import id.devnzr.pokedexify.core.data.api.PokemonApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val dataSourceModule = module {
    single {
        get<Retrofit>(named("BaseClient")).create(PokemonApi::class.java)
    }
}