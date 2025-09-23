package id.devnzr.pokedexify.core.data.repositories

import id.devnzr.pokdexify.models.response.PrimitiveResponse
import id.devnzr.pokedexify.core.data.interfaces.AuthRepository
import id.devnzr.pokedexify.core.datastore.DataStoreManager
import id.devnzr.pokedexify.database.dao.UserDao
import id.devnzr.pokedexify.database.entities.UserPokemonEntity
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl(
    private val dataStore: DataStoreManager,
    private val userDao: UserDao,
) : AuthRepository {

    override suspend fun checkUser(): Boolean =
        dataStore.isLoggedIn.first()

    override suspend fun getUser(): PrimitiveResponse<String> {
        val user = userDao.getFirstUser()
        return PrimitiveResponse(data = user?.email)
    }

    override suspend fun deleteUser() {
        dataStore.clearData()
        userDao.deleteAll()
    }

    override suspend fun login(userName: String, password: String) {
        val user = UserPokemonEntity(
            email = userName,
            password = password
        )
        userDao.insertUser(user)
        dataStore.setLoggedIn(true)
    }
}
