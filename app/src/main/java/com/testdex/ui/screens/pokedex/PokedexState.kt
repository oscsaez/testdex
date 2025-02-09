package com.testdex.ui.screens.pokedex

import com.testdex.ui.model.PokemonBasicsUIModel

data class PokedexState(
    val loading: Boolean = false,
    val pokemonList: List<PokemonBasicsUIModel> = emptyList()
)
