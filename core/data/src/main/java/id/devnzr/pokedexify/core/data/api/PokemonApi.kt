package id.devnzr.pokedexify.core.data.api

import id.devnzr.pokdexify.models.response.ObjectResponse
import id.devnzr.pokdexify.models.response.PaginateResponse
import id.devnzr.pokdexify.models.response.PokemonDetailResponse
import id.devnzr.pokdexify.models.response.PokemonResponse
import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PokemonApi {
    @GET("v2/pokemon")
    suspend fun fetchPokemon(
        @QueryMap queries: Map<String, @JvmSuppressWildcards Any>
    ): PaginateResponse<PokemonResponse, PokemonResult>

    @GET("v2/pokemon/{name}")
    fun getDetailPokemon(
        @Path("name") name: String
    ): ObjectResponse<PokemonDetailResponse, PokemonDetailResult>
}
