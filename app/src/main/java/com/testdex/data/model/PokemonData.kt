package com.testdex.data.model

data class PokemonData(
    val pokedexOrder: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<String>,
    val stats: List<StatData>,
    val abilities: List<AbilityData>,
    val moves: List<MoveData>,
    val sprite: SpriteData
)
