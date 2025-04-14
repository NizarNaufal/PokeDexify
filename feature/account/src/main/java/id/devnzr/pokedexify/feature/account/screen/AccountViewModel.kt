package id.devnzr.pokedexify.feature.account.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokedexify.core.domain.interfaces.GetUserUseCase
import id.devnzr.pokedexify.core.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class AccountViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val state get() = _state.asStateFlow()

    fun onEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is AccountEvent.OnGetAccount -> onGetUser()
        }
    }

    private fun onGetUser() {
        viewModelScope.launch {
            getUserUseCase().collect { result ->
                _state.update { it.copy(resultUser = result) }
            }
        }
    }
}