package id.devnzr.pokedexify.core.datastore.serializer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import id.devnzr.pokedexify.core.datastore.UserPreferences
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class EncryptedUserPreferencesSerializer(private val context: Context) : Serializer<UserPreferences> {

    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()

    private fun encryptedFile(): EncryptedFile {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val file = File(context.filesDir, "user_prefs_encrypted.pb")
        return EncryptedFile.Builder(
            file,
            context,
            masterKeyAlias,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
    }

    override suspend fun readFrom(input: InputStream): UserPreferences {
        return encryptedFile().openFileInput().use { UserPreferences.parseFrom(it) }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        encryptedFile().openFileOutput().use { t.writeTo(it) }
    }
}

fun Context.userPreferencesDataStore(): DataStore<UserPreferences> =
    DataStoreFactory.create(
        serializer = EncryptedUserPreferencesSerializer(this),
        produceFile = { File(filesDir, "user_prefs.pb") }
    )