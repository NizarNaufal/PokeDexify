package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName
import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.Result
import id.devnzr.pokdexify.models.result.ResultState

data class PrimitiveResponse<T>(
    @SerializedName("data") val data: T? = null
)

data class ListResponse<out T : Response<R>, R : Result>(
    @SerializedName("data") val data: List<T>? = null,
) : BaseResponse<T, R> {
    fun toResultStateSuccess(transform: (ListResponse<T, R>) -> List<R>): ResultState<List<R>> {
        return ResultState.Success(transform(this))
    }
}

data class SocketResponse<out T : Response<R>, R : Result>(
    @SerializedName("type") val type: String? = null,
    @SerializedName("data") val data: T? = null,
) : BaseResponse<T, R> {
    fun toResultStateSuccess(transform: (SocketResponse<T, R>) -> R): ResultState<R> {
        return ResultState.Success(transform(this))
    }
}

data class ObjectResponse<out T : Response<R>, R : Result>(
    @SerializedName("data") val data: T? = null,
) : BaseResponse<T, R> {
    fun toResultStateSuccess(transform: (ObjectResponse<T, R>) -> R): ResultState<R> {
        return ResultState.Success(transform(this))
    }
}

data class PaginateResponse<out T : Response<R>, R : Result>(
    @SerializedName("results") val data: List<T>? = null,
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
) : BaseResponse<T, R> {

    fun toResultStateSuccess(transform: (PaginateResponse<T, R>) -> PagingResult<R>): ResultState<PagingResult<R>> {
        return ResultState.Success(transform(this))
    }

    fun map(previousItems: List<R>? = null): PagingResult<R> {
        val combined = mutableListOf<R>().apply {
            previousItems?.let { addAll(it) }
            data?.map { it.map() }?.let { addAll(it) }
        }

        return PagingResult(
            count = count,
            next = next.orEmpty(),
            previous = previous.orEmpty(),
            items = combined
        )
    }
}

