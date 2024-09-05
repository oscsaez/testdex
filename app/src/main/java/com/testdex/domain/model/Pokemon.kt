package com.testdex.domain.model

data class Pokemon(
    val pokedexOrder: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<String>,
    val stats: List<Stat>,
    val abilities: List<Ability>,
    val moves: List<Move>,
    val sprite: Sprite
)
