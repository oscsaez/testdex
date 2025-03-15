package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonBasicsRemote(
    @SerialName("order")
    val pokedexOrder: Int,
    val name: String,
    val types: List<TypeRemote>
)
