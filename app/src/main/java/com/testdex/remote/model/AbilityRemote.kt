package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityRemote(
    @SerialName("ability")
    val abilityInfo: AbilityUrlRemote,
    @SerialName("is_hidden")
    val isHidden: Boolean
)

@Serializable
data class AbilityUrlRemote(
    val name: String,
    val url: String
)

@Serializable
data class AbilityEffectRemote(
    @SerialName("effect_entries")
    val effectEntries: List<EffectEntryRemote>
)
