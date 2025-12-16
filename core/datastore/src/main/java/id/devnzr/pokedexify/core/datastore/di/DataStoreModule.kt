package id.devnzr.pokedexify.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import id.devnzr.pokedexify.core.datastore.DataStoreManager
import id.devnzr.pokedexify.core.datastore.UserPreferences
import id.devnzr.pokedexify.core.datastore.crypto.CryptoManager
import id.devnzr.pokedexify.core.datastore.serializer.provideEncryptedUserPreferencesDataStore
import org.koin.dsl.module

val dataStoreModule = module {

    single { CryptoManager(get()) }

    single<DataStore<UserPreferences>> {
        provideEncryptedUserPreferencesDataStore(
            context = get(),
            cryptoManager = get()
        )
    }

    single { DataStoreManager(get()) }
}

