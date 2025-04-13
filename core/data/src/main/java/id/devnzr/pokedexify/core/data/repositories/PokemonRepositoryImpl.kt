package id.devnzr.pokedexify.core.data.repositories

import id.devnzr.pokdexify.models.response.PokemonResponse
import id.devnzr.pokedexify.core.data.api.PokemonApi
import id.devnzr.pokedexify.core.data.ext.PokemonQueryParams.LIMIT
import id.devnzr.pokedexify.core.data.ext.PokemonQueryParams.OFFSET
import id.devnzr.pokedexify.core.data.interfaces.PokemonRepository

class PokemonRepositoryImpl(private val api: PokemonApi) : PokemonRepository {
    override suspend fun fetchPokemonList() = api.fetchPokemon(
        mapOf(
            LIMIT to 20,
            OFFSET to 0
        )
    )
    override suspend fun fetchDetailPokemon(name: String): PokemonResponse = api.getDetailPokemon(name)
}
