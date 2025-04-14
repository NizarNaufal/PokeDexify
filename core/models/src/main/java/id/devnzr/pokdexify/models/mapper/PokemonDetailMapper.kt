package id.devnzr.pokdexify.models.mapper

import id.devnzr.pokdexify.models.response.Ability
import id.devnzr.pokdexify.models.response.AbilityResponse
import id.devnzr.pokdexify.models.response.FormResponse
import id.devnzr.pokdexify.models.response.PokemonDetailResponse
import id.devnzr.pokdexify.models.response.SpritesResponse
import id.devnzr.pokdexify.models.response.StatNameResponse
import id.devnzr.pokdexify.models.response.StatResponse
import id.devnzr.pokdexify.models.response.Type
import id.devnzr.pokdexify.models.response.TypeResponse
import id.devnzr.pokdexify.models.result.AbilityNameResult
import id.devnzr.pokdexify.models.result.AbilityResult
import id.devnzr.pokdexify.models.result.FormResult
import id.devnzr.pokdexify.models.result.PokemonDetailResult
import id.devnzr.pokdexify.models.result.SpritesResult
import id.devnzr.pokdexify.models.result.StatNameResult
import id.devnzr.pokdexify.models.result.StatResult
import id.devnzr.pokdexify.models.result.TypeNameResult
import id.devnzr.pokdexify.models.result.TypeResult

fun PokemonDetailResponse.toDomain(): PokemonDetailResult = PokemonDetailResult(
    id = id ?: 0,
    name = name.orEmpty(),
    baseExperience = baseExperience ?: 0,
    height = height ?: 0,
    isDefault = isDefault ?: false,
    order = order ?: 0,
    weight = weight ?: 0,
    types = types?.map { it.toDomain() } ?: emptyList(),
    abilities = abilities?.map { it.toDomain() } ?: emptyList(),
    forms = forms?.map { it.toDomain() } ?: emptyList(),
    sprites = sprites?.toDomain(),
    stats = stats?.map { it.toDomain() } ?: emptyList()
)

fun TypeResponse.toDomain() = TypeResult(
    slot = slot ?: 0,
    type = type?.toDomain()
)

fun Type.toDomain() = TypeNameResult(
    name = name.orEmpty()
)

fun AbilityResponse.toDomain() = AbilityResult(
    isHidden = isHidden ?: false,
    slot = slot ?: 0,
    ability = ability?.toDomain()
)

fun Ability.toDomain() = AbilityNameResult(
    name = name.orEmpty()
)

fun FormResponse.toDomain() = FormResult(
    name = name.orEmpty()
)

fun SpritesResponse.toDomain() = SpritesResult(
    frontDefault = frontDefault.orEmpty()
)

fun StatResponse.toDomain() = StatResult(
    baseStat = baseStat ?: 0,
    effort = effort ?: 0,
    stat = stat?.toDomain()
)

fun StatNameResponse.toDomain() = StatNameResult(
    name = name.orEmpty(),
    url = url.orEmpty()
)
