package id.devnzr.pokedexify.database.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import id.devnzr.pokedexify.database.constant.PokemonConstant

class PokemonDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "pokemon_database.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE ${PokemonConstant.TABLE_NAME} (
                ${PokemonConstant.COLUMN_NAME_ID} INTEGER PRIMARY KEY,
                ${PokemonConstant.COLUMN_NAME_NAME} TEXT,
                ${PokemonConstant.COLUMN_NAME_URL} TEXT
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${PokemonConstant.TABLE_NAME}")
        onCreate(db)
    }
}
