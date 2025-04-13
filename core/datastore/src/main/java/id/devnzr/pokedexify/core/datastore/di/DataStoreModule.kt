package id.devnzr.pokedexify.core.datastore.di

import android.content.Context
import id.devnzr.pokedexify.core.datastore.DataStoreManager
import id.devnzr.pokedexify.core.datastore.serializer.userPreferencesDataStore
import org.koin.dsl.module

val dataStoreModule = module {
    single { provideUserPreferenceManager(get()) }
}

fun provideUserPreferenceManager(context: Context): DataStoreManager {
    return DataStoreManager(context.userPreferencesDataStore)
}
