package com.testdex.ui.model

data class PokemonBasicsUIModel(
    val pokedexOrder: Int,
    val name: String,
    val types: List<TypeUIModel>
)
