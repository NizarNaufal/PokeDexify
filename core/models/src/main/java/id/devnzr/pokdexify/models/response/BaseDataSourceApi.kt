package id.devnzr.pokdexify.models.response

import com.google.gson.annotations.SerializedName

data class BaseDataSourceApi<T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: T?
)
