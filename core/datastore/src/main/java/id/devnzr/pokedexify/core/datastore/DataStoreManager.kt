package id.devnzr.pokedexify.core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import id.devnzr.pokedexify.core.datastore.UserPreferences

class DataStoreManager(private val dataStore: DataStore<UserPreferences>) {

    val isLoggedIn: Flow<Boolean> = dataStore.data.map { it.isLoggedIn }
    val userName: Flow<String> = dataStore.data.map { it.userName }

    suspend fun saveUser(userName: String) {
        dataStore.updateData { prefs ->
            prefs.toBuilder().setUserName(userName).setIsLoggedIn(true).build()
        }
    }

    suspend fun clearData() {
        dataStore.updateData { prefs ->
            prefs.toBuilder().clear().build()
        }
    }
}