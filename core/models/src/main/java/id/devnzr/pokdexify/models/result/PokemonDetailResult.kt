package id.devnzr.pokdexify.models.result

data class PokemonDetailResult(
    val id: Long,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val types: List<TypeResult>,
    val abilities: List<AbilityResult>,
    val forms: List<FormResult>,
    val sprites: SpritesResult?,
    val stats: List<StatResult>,
) : Result {
    companion object {
        fun empty() = PokemonDetailResult(
            id = 0,
            name = "",
            baseExperience = 0,
            height = 0,
            isDefault = false,
            order = 0,
            weight = 0,
            types = emptyList(),
            abilities = emptyList(),
            forms = emptyList(),
            sprites = null,
            stats = emptyList()
        )
    }
}

data class TypeResult(
    val slot: Int,
    val type: TypeNameResult?
) : Result

data class TypeNameResult(
    val name: String
) : Result

data class AbilityResult(
    val isHidden: Boolean,
    val slot: Int,
    val ability: AbilityNameResult?
) : Result

data class AbilityNameResult(
    val name: String
) : Result

data class FormResult(
    val name: String
) : Result

data class SpritesResult(
    val frontDefault: String
) : Result

data class StatResult(
    val baseStat: Int,
    val effort: Int,
    val stat: StatNameResult?
) : Result

data class StatNameResult(
    val name: String,
    val url: String
) : Result
