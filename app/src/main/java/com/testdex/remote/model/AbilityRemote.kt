package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityRemote(
    val name: String,
    @SerialName("effect")
    val description: String,
    val isHidden: Boolean
)
