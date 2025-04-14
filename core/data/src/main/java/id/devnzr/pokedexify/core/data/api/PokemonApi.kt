package id.devnzr.pokedexify.core.data.api

import id.devnzr.pokdexify.models.response.PaginateResponse
import id.devnzr.pokdexify.models.response.PokemonDetailResponse
import id.devnzr.pokdexify.models.response.PokemonResponse
import id.devnzr.pokdexify.models.result.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemon(
        @QueryMap queries: Map<String, @JvmSuppressWildcards Any>
    ): PaginateResponse<PokemonResponse, PokemonResult>

    @GET("pokemon/{name}")
    suspend fun getDetailPokemon(
        @Path("name") name: String
    ): PokemonDetailResponse
}
