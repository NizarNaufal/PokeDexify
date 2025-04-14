package id.devnz.pokdexify.feature.home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.pokdexify.models.result.PagingResult
import id.devnzr.pokdexify.models.result.PokemonResult
import id.devnzr.pokdexify.models.result.ResultState
import id.devnzr.pokdexify.models.result.dataOrNull
import id.devnzr.pokedexify.core.domain.interfaces.GetPokemonListUseCase
import id.devnzr.pokedexify.core.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getListPokemonUseCase: GetPokemonListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state get() = _state.asStateFlow()

    init {
        getPokemonList()
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            is HomeEvent.OnGetAllData -> getPokemonList()
            is HomeEvent.OnSearch -> searchPokemon(event.query)
            else -> Unit
        }
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            _state.update { it.copy(pokemonList = ResultState.Loading()) }
            getListPokemonUseCase(
                refreshing = false,
                previous = _state.value.pokemonList.data
            ).collect { result ->
                when (result) {
                    is ResultState.Success -> {
                        val entries = result.data?.items.orEmpty().map { entry ->
                            val number = entry.url?.trimEnd('/')?.takeLastWhile { it.isDigit() }
                            val imageUrl =
                                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
                            PokemonResult(
                                id = entry.id,
                                name = entry.name?.replaceFirstChar {
                                    if (it.isLowerCase()) {
                                        it.titlecase(java.util.Locale.ROOT)
                                    } else {
                                        it.toString()
                                    }
                                }.orEmpty(),
                                url = imageUrl
                            )
                        }

                        val combinedList = _state.value.pokemonList.dataOrNull()?.items.orEmpty() + entries
                        val paging = PagingResult(
                            count = result.data?.count ?: 0,
                            next = result.data?.next.orEmpty(),
                            previous = result.data?.previous.orEmpty(),
                            items = combinedList
                        )

                        _state.update {
                            it.copy(
                                pokemonList = ResultState.Success(data = paging),
                                isSearching = false,
                                isSearchStarting = true
                            )
                        }
                    }

                    is ResultState.Error -> {
                        _state.update {
                            it.copy(
                                pokemonList = ResultState.Error(
                                    code = result.code,
                                    message = result.message
                                )
                            )
                        }
                    }

                    else -> Unit
                }
            }
        }
    }

    private fun searchPokemon(query: String) {
        val currentItems = _state.value.pokemonList.dataOrNull()?.items.orEmpty()

        viewModelScope.launch {
            if (query.isBlank()) {
                _state.update {
                    it.copy(
                        isSearching = false,
                        isSearchStarting = true
                    )
                }
                return@launch
            }

            val listToSearch =
                if (_state.value.isSearchStarting) currentItems else _state.value.cachedPokemonList
            val filtered = listToSearch.filter {
                it.name?.contains(query.trim(), ignoreCase = true) == true ||
                    it.id.toString() == query.trim()
            }

            _state.update {
                it.copy(
                    cachedPokemonList = if (it.isSearchStarting) currentItems else it.cachedPokemonList,
                    pokemonList = ResultState.Success(
                        PagingResult(
                            count = filtered.size,
                            next = "",
                            previous = "",
                            items = filtered
                        )
                    ),
                    isSearching = true,
                    isSearchStarting = false
                )
            }
        }
    }
}
