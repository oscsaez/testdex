package com.testdex.ui.model

data class PokemonUIModel(
    val pokedexOrder: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<TypeUIModel>,
    val stats: List<StatUIModel>,
    val abilities: List<AbilityUIModel>,
    val moves: List<MoveUIModel>,
    val sprite: SpriteUIModel
) {
    init {
        require(types.size in 1..2) {
            "Types list can contain only one or two elements"
        }
        require(stats.size == 6) {
            "Stats list should contain exactly 6 elements"
        }
        require(abilities.size in 1..2) {
            "Abilities list can contain only one or two elements"
        }
    }
}
