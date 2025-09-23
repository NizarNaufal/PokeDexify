package id.devnzr.pokedexify.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.devnzr.pokedexify.database.entities.UserPokemonEntity

@Dao
interface UserDao {

    @Query(
        "SELECT * FROM ms_user " +
                "WHERE email = :email AND password = :password " +
                "LIMIT 1"
    )
    suspend fun getUserByEmailPassword(
        email: String,
        password: String,
    ): UserPokemonEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserPokemonEntity)

    @Query("SELECT * FROM ms_user LIMIT 1")
    suspend fun getFirstUser(): UserPokemonEntity?

    @Query("DELETE FROM ms_user")
    suspend fun deleteAll()
}

