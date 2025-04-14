package id.devnzr.pokedexify.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokedexify.core.domain.interfaces.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getUserUseCase().collect { resultState ->
                _state.update {
                    it.copy(resultState = resultState)
                }
            }
        }
    }
}