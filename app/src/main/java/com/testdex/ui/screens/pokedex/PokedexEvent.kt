package com.testdex.ui.screens.pokedex

sealed class PokedexEvent {
    object RetrieveAllPokemonBasicsList: PokedexEvent()
    data class SearchPokemonByName(val name: String): PokedexEvent()
}
