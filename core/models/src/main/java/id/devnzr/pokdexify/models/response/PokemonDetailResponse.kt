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
)


data class TypeResponse(
    @SerializedName("slot") val slot: Int?,
    @SerializedName("type") val type: Type?
)

data class Type(
    @SerializedName("name") val name: String?
)

data class AbilityResponse(
    @SerializedName("is_hidden") val isHidden: Boolean?,
    @SerializedName("slot") val slot: Int?,
    @SerializedName("ability") val ability: Ability?
)

data class Ability(
    @SerializedName("name") val name: String?
)

data class FormResponse(
    @SerializedName("name") val name: String?
)

data class SpritesResponse(
    @SerializedName("front_default") val frontDefault: String?
)

data class StatResponse(
    @SerializedName("base_stat") val baseStat: Int?,
    @SerializedName("effort") val effort: Int?,
    @SerializedName("stat") val stat: StatNameResponse?
)

data class StatNameResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)
