package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.ResultState
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {
    operator fun invoke(): Flow<ResultState<String>>
}
