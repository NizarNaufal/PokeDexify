package id.devnzr.pokedexify.core.data.interfaces

interface AuthRepository {
    suspend fun login(userName: String, password: String)
    suspend fun checkUser(): Boolean
    suspend fun deleteUser()
}
