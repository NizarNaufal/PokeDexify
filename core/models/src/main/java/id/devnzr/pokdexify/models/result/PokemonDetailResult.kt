package id.devnzr.pokdexify.models.result

data class PokemonDetailResult(
    val id: Long = 0,
    val name: String = "",
    val url: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val experience: Int = 0,
    val types: List<TypeResult> = emptyList()
): Result
