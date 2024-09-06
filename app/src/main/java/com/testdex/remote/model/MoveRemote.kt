package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveRemote(
    val name: String,
    val power: Int?,
    val accuracy: Int?,
    val pp: Int,
    @SerialName("effect")
    val description: String,
    val type: String // Be careful with this
)
