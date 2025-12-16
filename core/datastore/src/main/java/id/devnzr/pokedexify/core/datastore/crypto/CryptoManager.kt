package id.devnzr.pokedexify.core.datastore.crypto

import android.content.Context
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.StreamingAead
import com.google.crypto.tink.config.TinkConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.io.InputStream
import java.io.OutputStream

class CryptoManager(context: Context) {

    init {
        TinkConfig.register()
    }

    private val aead = AndroidKeysetManager.Builder()
        .withSharedPref(context, "POKE_DEX_KEYSET", "pokedex_pref")
        .withKeyTemplate(KeyTemplates.get("AES128_GCM_HKDF_4KB"))
        .withMasterKeyUri("android-keystore://master_key")
        .build()
        .keysetHandle
        .getPrimitive(StreamingAead::class.java)

    fun encrypt(outputStream: OutputStream): OutputStream =
        aead.newEncryptingStream(outputStream, ByteArray(0))

    fun decrypt(inputStream: InputStream): InputStream =
        aead.newDecryptingStream(inputStream, ByteArray(0))
}
