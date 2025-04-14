package id.devnzr.pokedexify.feature.detail.screen

import id.devnzr.pokedexify.core.extension.UiEvent

sealed class DetailEvent : UiEvent {
    data class OnGetDetail(val id: String) : DetailEvent()
    data object OnNavigateBack : DetailEvent()
}
