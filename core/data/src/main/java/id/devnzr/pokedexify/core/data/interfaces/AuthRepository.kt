package id.devnzr.pokedexify.core.data.interfaces

import id.devnzr.pokdexify.models.response.PrimitiveResponse

interface AuthRepository {
    suspend fun login(userName: String, password: String)
    suspend fun checkUser(): Boolean
    suspend fun getUser(): PrimitiveResponse<String>
    suspend fun deleteUser()
}
