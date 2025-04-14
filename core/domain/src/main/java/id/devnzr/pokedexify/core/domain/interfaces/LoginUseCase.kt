package id.devnzr.pokedexify.core.domain.interfaces

import id.devnzr.pokdexify.models.result.ResultState
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    operator fun invoke(userName: String, password: String): Flow<ResultState<String>>
}
