package id.devnzr.pokedexify.feature.login.screen

import id.devnzr.pokedexify.core.extension.UiEvent

sealed class LoginEvent : UiEvent {
    data object OnNavigateBack : LoginEvent()
    data class OnNameChange(val email: String) : LoginEvent()
    data class OnPasswordChange(val password: String) : LoginEvent()
    data object OnSignInClick : LoginEvent()
}
