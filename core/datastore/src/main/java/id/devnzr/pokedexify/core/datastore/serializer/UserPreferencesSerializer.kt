package id.devnzr.pokedexify.core.datastore.serializer

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.migrations.SharedPreferencesMigration
import androidx.datastore.migrations.SharedPreferencesView
import id.devnzr.pokedexify.core.datastore.UserPreferences
import id.devnzr.pokedexify.core.datastore.crypto.CryptoManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class UserPreferencesSerializer(
    private val cryptoManager: CryptoManager
) : Serializer<UserPreferences> {

    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        return try {
            val decryptedStream = cryptoManager.decrypt(input)
            UserPreferences.parseFrom(decryptedStream)
        } catch (e: Exception) {
            throw CorruptionException("Cannot read encrypted user preferences", e)
        }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        val encryptedStream = cryptoManager.encrypt(output)
        t.writeTo(encryptedStream)
        withContext(Dispatchers.IO) {
            encryptedStream.flush()
        }
    }
}


fun provideEncryptedUserPreferencesDataStore(
    context: Context,
    cryptoManager: CryptoManager
): DataStore<UserPreferences> {

    return DataStoreFactory.create(
        serializer = UserPreferencesSerializer(cryptoManager),
        migrations = listOf(
            SharedPreferencesMigration(
                context,
                "pokedex_prefs"
            ) { sharedPrefs, currentData ->
                currentData.toBuilder()
                    .setIsLoggedIn(sharedPrefs.getBoolean("is_logged_in", false) ?: false)
                    .setUserName(sharedPrefs.getString("username", "") ?: "")
                    .build()
            }
        ),
        produceFile = {
            context.dataStoreFile("user_prefs.pb")
        }
    )
}

