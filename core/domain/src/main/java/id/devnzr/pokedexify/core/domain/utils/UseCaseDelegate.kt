package id.devnzr.pokedexify.core.domain.utils

import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokdexify.models.result.neutralize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object UseCaseDelegate {
    fun <T> neutralizeResultFlow(
        previous: T? = null,
        delay: Long = 1000L,
        errorDelay: Long = 4000L,
        block: (suspend () -> ResultState<T>)
    ): Flow<ResultState<T>> = flow {
        try {
            emit(ResultState.Loading(previous = previous))

            val response = block()

            neutralize(
                value = response,
                previous = response.data,
                delay = delay
            )
        } catch (e: Throwable) {
            neutralize(
                value = e.toResultStateError(),
                previous = previous,
                delay = errorDelay
            )
        }
    }

    fun <T> paginateFlow(
        previous: PagingResult<T>?,
        delay: Long = 1000L,
        errorDelay: Long = 4000L,
        block: suspend () -> ResultState<PagingResult<T>>
    ): Flow<ResultState<PagingResult<T>>> = flow {
        try {
            val hasNext = !previous?.next.isNullOrEmpty()

            if (previous == null || hasNext) {
                emit(ResultState.Loading(previous))

                val response = block()

                neutralize(
                    value = response,
                    previous = response.data,
                    delay = delay
                )
            } else {
                emit(ResultState.Idle(previous))
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            neutralize(
                value = e.toResultStateError(),
                previous = previous,
                delay = errorDelay
            )
        }
    }
}
