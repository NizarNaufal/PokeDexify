package id.devnzr.pokedexify.core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import id.devnzr.pokedexify.core.datastore.UserPreferences

class DataStoreManager(private val dataStore: DataStore<UserPreferences>) {

    val isLoggedIn: Flow<Boolean> = dataStore.data.map { it.isLoggedIn }

    suspend fun setLoggedIn(isLoggedIn: Boolean) {
        dataStore.updateData { prefs ->
            prefs.toBuilder()
                .setIsLoggedIn(isLoggedIn)
                .build()
        }
    }

    suspend fun clearData() {
        dataStore.updateData { prefs ->
            prefs.toBuilder().clear().build()
        }
    }
}
