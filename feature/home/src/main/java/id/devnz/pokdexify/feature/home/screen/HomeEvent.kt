package id.devnz.pokdexify.feature.home.screen

import id.devnzr.pokedexify.core.extension.UiEvent

sealed class HomeEvent : UiEvent {
    data class OnSearch(val query: String) : HomeEvent()
    data object OnGetAllData : HomeEvent()
    data object OnLoadMore : HomeEvent()
    data class OnNavigateToDetail(val id: String) : HomeEvent()
}
