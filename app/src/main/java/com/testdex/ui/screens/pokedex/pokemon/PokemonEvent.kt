package com.testdex.ui.screens.pokedex.pokemon

sealed class PokemonEvent {
    data class RetrievePokemon(val name: String): PokemonEvent()
}