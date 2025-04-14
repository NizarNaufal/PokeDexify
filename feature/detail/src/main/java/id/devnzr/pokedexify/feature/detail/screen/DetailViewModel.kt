package id.devnzr.pokedexify.feature.detail.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonDetailUseCase
import id.devnzr.pokedexify.core.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class DetailViewModel(
    private val getDetailPokemonUseCase: GetPokemonDetailUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state get() = _state.asStateFlow()

    fun onEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is DetailEvent.OnGetDetail -> onGetDetail(uiEvent.id)
        }
    }

    private fun onGetDetail(id: String) {
        viewModelScope.launch {
            getDetailPokemonUseCase(id.toLong()).collect { result ->
                _state.update { it.copy(resultPokemonData = result) }
            }
        }
    }
}
