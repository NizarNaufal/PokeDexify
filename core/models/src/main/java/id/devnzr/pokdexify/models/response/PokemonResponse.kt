package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName
import id.devnzr.pokdexify.models.result.PokemonResult

data class PokemonResponse(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
) : Response<PokemonResult>() {
    override fun map(): PokemonResult {
        return PokemonResult(
            id = id,
            name = name,
            url = url
        )
    }
}
