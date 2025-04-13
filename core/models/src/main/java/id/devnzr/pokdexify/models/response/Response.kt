package id.devnzr.pokdexify.models.response

import id.devnzr.pokdexify.models.result.Result

interface BaseResponse<out T : Response<R>, R : Result>

abstract class Response<T : Result> {
    abstract fun map(): T
}

@JvmName("mapResponse")
fun <R : Result, T : Response<R>, F> T.map(transform: (T) -> F): F {
    return transform(this)
}

@JvmName("mapListResponse")
fun <T : Response<R>, R : Result> List<T>.map(): List<R> {
    return this.map { response -> response.map() }
}

@JvmName("mapNullableListResponse")
fun <T : Response<R>, R : Result> List<T>?.map(): List<R> {
    return this?.map { response -> response.map() } ?: emptyList()
}