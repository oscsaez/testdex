package com.testdex.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonRemote(
    @SerializedName("order")
    val pokedexOrder: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<String>, // Be careful with this
    val stats: List<StatRemote>,
    val abilities: List<AbilityRemote>,
    val moves: List<MoveRemote>,
    @SerializedName("sprites")
    val sprite: SpriteRemote
)
