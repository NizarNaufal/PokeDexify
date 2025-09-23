package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.data.interfaces.AuthRepository
import id.devnzr.pokedexify.core.domain.interfaces.GetUserUseCase
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import kotlinx.coroutines.flow.Flow

class GetUserUseCaseImpl(private val authRepository: AuthRepository) : GetUserUseCase {
    override fun invoke(): Flow<ResultState<String>> =
        UseCaseDelegate.neutralizeResultFlow {
            val result = authRepository.getUser()
            if (result.data == null) {
                ResultState.Error(code = 400, message = "User not found", null)
            } else {
                ResultState.Success(data = result.data.orEmpty())
            }
        }
}
