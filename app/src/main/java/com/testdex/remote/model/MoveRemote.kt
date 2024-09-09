package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveRemote(
    @SerialName("move")
    val moveUrl: MoveUrlRemote
)

@Serializable
data class MoveUrlRemote(
    val name: String,
    val url: String
)

@Serializable
data class MoveInfoRemote(
    val power: Int?,
    val accuracy: Int?,
    val pp: Int,
    @SerialName("effect_entries")
    val effectEntries: List<EffectEntryRemote>,
    val type: String // Be careful with this
)
