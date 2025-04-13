package id.devnzr.pokedexify.core.data.interfaces

import id.devnzr.pokdexify.models.response.PaginateResponse
import id.devnzr.pokdexify.models.response.PokemonResponse
import id.devnzr.pokdexify.models.result.PokemonResults

interface PokemonRepository {
    suspend fun fetchPokemonList(): PaginateResponse<PokemonResponse, PokemonResults>
    suspend fun fetchDetailPokemon(name: String): PokemonResponse
}
