package id.devnzr.pokdexify.models.result

data class FavoritesResult(
    val id: Long,
    val name: String,
    val imageUrl: String,
) : Result {
    companion object {
        fun empty() = FavoritesResult(
            id = 0,
            name = "",
            imageUrl = ""
        )
    }
}
