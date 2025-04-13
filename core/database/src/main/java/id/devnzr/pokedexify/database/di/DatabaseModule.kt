package id.devnzr.pokedexify.database.di

import id.devnzr.pokedexify.database.dao.PokemonDao
import id.devnzr.pokedexify.database.helper.PokemonDatabaseHelper
import org.koin.dsl.module

val databaseModule = module {
    single { PokemonDatabaseHelper(get()) }
    single { PokemonDao(get()) }
}
