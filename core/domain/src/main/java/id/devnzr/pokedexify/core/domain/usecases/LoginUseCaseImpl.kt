package id.devnzr.pokedexify.core.domain.usecases

import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokedexify.core.data.interfaces.AuthRepository
import id.devnzr.pokedexify.core.domain.interfaces.LoginUseCase
import id.devnzr.pokedexify.core.domain.utils.UseCaseDelegate
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(private val authRepository: AuthRepository) : LoginUseCase {
    override fun invoke(userName: String, password: String): Flow<ResultState<String>> =
        UseCaseDelegate.neutralizeResultFlow {
            authRepository.login(userName, password)
            ResultState.Success(data = "Success")
        }
}
