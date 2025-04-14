package id.devnzr.pokedexify.feature.login.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokedexify.core.domain.interfaces.LoginUseCase
import id.devnzr.pokedexify.core.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is LoginEvent.OnNameChange -> updateUsername(event.email)
            is LoginEvent.OnPasswordChange -> updatePassword(event.password)
            else -> Unit
        }
    }

    private fun updateUsername(value: String) = _state.update {
        it.copy(userName = value)
    }

    private fun updatePassword(value: String) = _state.update {
        it.copy(password = value)
    }

    private fun handleSubmit() {
        val username = _state.value.userName
        val password = _state.value.password

        val usernameError = if (username.isBlank()) "Username required" else null
        val passwordError = if (password.isBlank()) "Password required" else null

        if (usernameError != null || passwordError != null) {
            _state.update {
                it.copy(
                    userName = it.userName,
                    password = it.password
                )
            }
            return
        }

        viewModelScope.launch {
            loginUseCase(username, password).collect {
                _state.update { state ->
                    state.copy(resultLogin = it)
                }
            }
        }
    }
}