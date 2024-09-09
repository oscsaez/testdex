package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeRemote(
    @SerialName("type")
    val typeInfo: TypeInfoRemote
)

@Serializable
data class TypeInfoRemote(
    val name: String
)
