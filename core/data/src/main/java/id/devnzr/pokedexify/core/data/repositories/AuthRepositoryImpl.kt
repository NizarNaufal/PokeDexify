package id.devnzr.pokedexify.core.data.repositories

import id.devnzr.pokedexify.core.data.interfaces.AuthRepository
import id.devnzr.pokedexify.core.datastore.DataStoreManager
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl(
    private val dataStore: DataStoreManager
) : AuthRepository {

    override suspend fun checkUser(): Boolean {
        return dataStore.isLoggedIn.first()
    }

    override suspend fun deleteUser() = dataStore.clearData()

    override suspend fun login(userName: String, password: String) {
       return dataStore.saveUser(userName)
    }
}