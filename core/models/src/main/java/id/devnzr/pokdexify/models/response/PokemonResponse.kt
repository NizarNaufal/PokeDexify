package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName
import id.devnzr.pokdexify.models.result.PokemonResults

data class PokemonResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
): Response<PokemonResults>() {
    override fun map(): PokemonResults {
        return PokemonResults(
            name = name,
            url = url
        )
    }
}
