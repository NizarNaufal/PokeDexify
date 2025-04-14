package id.devnzr.pokedexify.core.data.interfaces

import id.devnzr.pokdexify.models.response.PaginateResponse
import id.devnzr.pokdexify.models.response.PokemonDetailResponse
import id.devnzr.pokdexify.models.response.PokemonResponse
import id.devnzr.pokdexify.models.result.PokemonResult

interface PokemonRepository {
    suspend fun fetchPokemonList(): PaginateResponse<PokemonResponse, PokemonResult>
    suspend fun fetchDetailPokemon(name: String): PokemonDetailResponse
}
