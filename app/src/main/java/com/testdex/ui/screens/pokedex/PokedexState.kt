package com.testdex.ui.screens.pokedex

import com.testdex.ui.model.PokemonUIModel

data class PokedexState(
    val loading: Boolean = true,
    val loadingMore: Boolean = false,
    val pokemonList: List<PokemonUIModel> = emptyList()
)
