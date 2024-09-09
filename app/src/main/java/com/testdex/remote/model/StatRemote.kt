package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatRemote(
    @SerialName("stat")
    val statInfo: StatInfoRemote,
    @SerialName("base_stat")
    val base: Int
)

@Serializable
data class StatInfoRemote(
    val name: String
)
