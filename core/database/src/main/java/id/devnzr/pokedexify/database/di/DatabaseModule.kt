package id.devnzr.pokedexify.database.di

import androidx.room.Room
import id.devnzr.pokedexify.database.databases.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        val db = Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "pokedexify_database"
        )
            .fallbackToDestructiveMigration()
            .build()
        db
    }

    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().favoriteDao() }
}
