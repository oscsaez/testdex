package com.testdex.ui.screens.pokedex

sealed class PokedexEvent {
    object RetrievePokemonList: PokedexEvent()
    data class SearchPokemonByName(val name: String): PokedexEvent()
}
