package com.testdex.ui.screens.pokedex.pokemon

import com.testdex.ui.model.PokemonUIModel

data class PokemonState(
    val loading: Boolean = false,
    val pokemon: PokemonUIModel? = null
)
