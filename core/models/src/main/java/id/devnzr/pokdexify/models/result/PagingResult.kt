package id.devnzr.pokdexify.models.result

data class PagingResult<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val items: List<T>,
) {
    companion object {
        fun <T> empty(): PagingResult<T> {
            return PagingResult(
                count = 0,
                next = "",
                previous = "",
                items = emptyList()
            )
        }
    }
}

@JvmName("mapPagingResult")
fun <T, R> PagingResult<T>.map(transform: (PagingResult<T>) -> R): R {
    return transform(this)
}