package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatRemote(
    val name: String, // Be careful with this
    @SerialName("base_stat")
    val base: Int
)
