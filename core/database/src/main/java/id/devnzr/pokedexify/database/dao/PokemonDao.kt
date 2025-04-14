package id.devnzr.pokedexify.database.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import id.devnzr.pokedexify.database.constant.PokemonConstant
import id.devnzr.pokedexify.database.helper.PokemonDatabaseHelper

class PokemonDao(context: Context) {

    private val dbHelper = PokemonDatabaseHelper(context)

    fun insert(pokemon: PokemonResult): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(PokemonConstant.COLUMN_NAME_ID, pokemon.id)
            put(PokemonConstant.COLUMN_NAME_NAME, pokemon.name)
            put(PokemonConstant.COLUMN_NAME_URL, pokemon.url)
        }
        return db.insertWithOnConflict(
            PokemonConstant.TABLE_NAME,
            null,
            values,
            SQLiteDatabase.CONFLICT_REPLACE
        )
    }

    fun getAll(): List<PokemonResult> {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            PokemonConstant.TABLE_NAME,
            arrayOf(
                PokemonConstant.COLUMN_NAME_ID,
                PokemonConstant.COLUMN_NAME_NAME,
                PokemonConstant.COLUMN_NAME_URL
            ),
            null, null, null, null, null
        )

        val list = mutableListOf<PokemonResult>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(PokemonConstant.COLUMN_NAME_ID))
                val name = getString(getColumnIndexOrThrow(PokemonConstant.COLUMN_NAME_NAME))
                val type = getString(getColumnIndexOrThrow(PokemonConstant.COLUMN_NAME_URL))
                list.add(PokemonResult(id, name, type))
            }
        }
        cursor.close()
        return list
    }

    fun getById(id: Long): PokemonResult? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            PokemonConstant.TABLE_NAME,
            arrayOf(
                PokemonConstant.COLUMN_NAME_ID,
                PokemonConstant.COLUMN_NAME_NAME,
                PokemonConstant.COLUMN_NAME_URL
            ),
            "${PokemonConstant.COLUMN_NAME_ID} = ?",
            arrayOf(id.toString()),
            null, null, null
        )

        var pokemon: PokemonResult? = null
        if (cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(PokemonConstant.COLUMN_NAME_NAME))
            val type = cursor.getString(cursor.getColumnIndexOrThrow(PokemonConstant.COLUMN_NAME_URL))
            pokemon = PokemonResult(id, name, type)
        }
        cursor.close()
        return pokemon
    }

    fun delete(id: Long) {
        val db = dbHelper.writableDatabase
        db.delete(
            PokemonConstant.TABLE_NAME,
            "${PokemonConstant.COLUMN_NAME_ID} = ?",
            arrayOf(id.toString())
        )
    }
}
