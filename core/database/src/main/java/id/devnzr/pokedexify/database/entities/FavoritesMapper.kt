package id.devnzr.pokedexify.database.entities

import id.devnzr.pokdexify.models.result.FavoritesResult

fun FavoritePokemonEntity.toResult(): FavoritesResult {
    return FavoritesResult(
        id = this.id.toLong(),
        name = this.name,
        imageUrl = this.imageUrl
    )
}

fun List<FavoritePokemonEntity>.toResultList(): List<FavoritesResult> =
    this.map { it.toResult() }

fun FavoritesResult.toEntity(): FavoritePokemonEntity {
    return FavoritePokemonEntity(
        id = this.id.toInt(),
        name = this.name,
        imageUrl = this.imageUrl
    )
}

