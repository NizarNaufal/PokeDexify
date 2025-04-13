package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName
import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.TypeNameResult
import id.devnzr.pokdexify.models.result.TypeResult

data class PokemonDetailResponse(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("height") val height: Int?,
    @SerializedName("weight") val weight: Int?,
    @SerializedName("base_experience") val experience: Int?,
    @SerializedName("types") val types: List<TypeResponse>?
) : Response<PokemonDetailResult>() {
    override fun map(): PokemonDetailResult {
        return PokemonDetailResult(
            id = id,
            name = name,
            url = url,
            height = height,
            weight = weight,
            experience = experience,
            types = types?.map { it.map() } ?: emptyList()
        )
    }

    data class TypeResponse(
        @SerializedName("slot") val slot: Int?,
        @SerializedName("type") val type: Type?
    ) {
        fun map(): TypeResult {
            return TypeResult(
                slot = slot ?: 0,
                type = type?.map()
            )
        }
    }

    data class Type(
        @SerializedName("name") val name: String?
    ) {
        fun map(): TypeNameResult {
            return TypeNameResult(
                name = name.orEmpty()
            )
        }
    }
}
