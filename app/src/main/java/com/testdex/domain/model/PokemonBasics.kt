package com.testdex.domain.model

data class PokemonBasics(
    val pokedexOrder: Int,
    val name: String,
    val types: List<String>
)