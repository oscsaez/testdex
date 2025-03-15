package com.testdex.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class AllPokemonInfoRemote(
    val count: Int,
    val results: List<PokemonInfoRemote>
)

@Serializable
data class PokemonInfoRemote(
    val name: String,
    val url: String
)
