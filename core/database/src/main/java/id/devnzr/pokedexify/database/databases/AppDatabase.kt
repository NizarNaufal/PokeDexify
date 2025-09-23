package id.devnzr.pokedexify.database.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import id.devnzr.pokedexify.database.dao.FavoritePokemonDao
import id.devnzr.pokedexify.database.dao.UserDao
import id.devnzr.pokedexify.database.entities.FavoritePokemonEntity
import id.devnzr.pokedexify.database.entities.UserPokemonEntity

@Database(
    entities = [
        UserPokemonEntity::class,
        FavoritePokemonEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun favoriteDao(): FavoritePokemonDao
}
