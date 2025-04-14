package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName
import id.devnzr.pokdexify.models.result.AbilityNameResult
import id.devnzr.pokdexify.models.result.AbilityResult
import id.devnzr.pokdexify.models.result.FormResult
import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.SpritesResult
import id.devnzr.pokdexify.models.result.StatNameResult
import id.devnzr.pokdexify.models.result.StatResult
import id.devnzr.pokdexify.models.result.TypeNameResult
import id.devnzr.pokdexify.models.result.TypeResult

data class PokemonDetailResponse(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("base_experience") val baseExperience: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("is_default") val isDefault: Boolean?,
    @SerializedName("order") val order: Int?,
    @SerializedName("weight") val weight: Int?,
    @SerializedName("types") val types: List<TypeResponse>?,
    @SerializedName("abilities") val abilities: List<AbilityResponse>?,
    @SerializedName("forms") val forms: List<FormResponse>?,
    @SerializedName("sprites") val sprites: SpritesResponse?,
    @SerializedName("stats") val stats: List<StatResponse>?
) : Response<PokemonDetailResult>() {
    override fun map(): PokemonDetailResult {
        return PokemonDetailResult(
            id = id ?: 0,
            name = name.orEmpty(),
            baseExperience = baseExperience ?: 0,
            height = height ?: 0,
            isDefault = isDefault ?: false,
            order = order ?: 0,
            weight = weight ?: 0,
            types = types?.map { it.map() } ?: emptyList(),
            abilities = abilities?.map { it.map() } ?: emptyList(),
            forms = forms?.map { it.map() } ?: emptyList(),
            sprites = sprites?.map(),
            stats = stats?.map { it.map() } ?: emptyList()
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

    data class AbilityResponse(
        @SerializedName("is_hidden") val isHidden: Boolean?,
        @SerializedName("slot") val slot: Int?,
        @SerializedName("ability") val ability: Ability?
    ) {
        fun map(): AbilityResult {
            return AbilityResult(
                isHidden = isHidden ?: false,
                slot = slot ?: 0,
                ability = ability?.map()
            )
        }
    }

    data class Ability(
        @SerializedName("name") val name: String?
    ) {
        fun map(): AbilityNameResult {
            return AbilityNameResult(
                name = name.orEmpty()
            )
        }
    }

    data class FormResponse(
        @SerializedName("name") val name: String?
    ) {
        fun map(): FormResult {
            return FormResult(
                name = name.orEmpty()
            )
        }
    }

    data class SpritesResponse(
        @SerializedName("front_default") val frontDefault: String?
    ) {
        fun map(): SpritesResult {
            return SpritesResult(
                frontDefault = frontDefault.orEmpty()
            )
        }
    }

    data class StatResponse(
        @SerializedName("base_stat") val baseStat: Int?,
        @SerializedName("effort") val effort: Int?,
        @SerializedName("stat") val stat: StatNameResponse?
    ) {
        fun map() = StatResult(
            baseStat = baseStat ?: 0,
            effort = effort ?: 0,
            stat = stat?.map()
        )
    }

    data class StatNameResponse(
        @SerializedName("name") val name: String?,
        @SerializedName("url") val url: String?
    ) {
        fun map() = StatNameResult(
            name = name.orEmpty(),
            url = url.orEmpty()
        )
    }
}
