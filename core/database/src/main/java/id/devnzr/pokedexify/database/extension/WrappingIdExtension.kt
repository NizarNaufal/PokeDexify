package id.devnzr.pokedexify.database.extension

object WrappingIdExtension {
    fun extractIdFromUrl(url: String): Int {
        return url.trimEnd('/').split("/").last().toIntOrNull() ?: 0
    }
}