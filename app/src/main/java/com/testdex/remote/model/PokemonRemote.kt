package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonRemote(
    @SerialName("order")
    val pokedexOrder: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<String>, // Be careful with this
    val stats: List<StatRemote>,
    val abilities: List<AbilityRemote>,
    val moves: List<MoveRemote>,
    @SerialName("sprites")
    val sprite: SpriteRemote
)
