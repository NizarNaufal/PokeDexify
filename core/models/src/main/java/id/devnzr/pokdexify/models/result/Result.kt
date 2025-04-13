package id.devnzr.pokdexify.models.result

interface Result

@JvmName("mapResult")
fun <T : Result, R> T.map(transform: (T) -> R): R {
    return transform(this)
}