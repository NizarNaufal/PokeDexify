package id.devnzr.pokedexify.feature.account.screen

import id.devnzr.pokedexify.core.extension.UiEvent

sealed class AccountEvent : UiEvent {
    data object OnGetAccount : AccountEvent()
    data object OnNavigateLogin : AccountEvent()
}
