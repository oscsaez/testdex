package com.testdex.ui.model

import com.testdex.ui.utils.UIConstants

data class PokemonBasicsUIModel(
    val pokedexOrder: Int,
    val name: String,
    val types: List<TypeUIModel>
) {
    val isPokedexOrderAvailable: Boolean
        get() = pokedexOrder != UIConstants.NOT_AVAILABLE_POKEDEX_ORDER
}
