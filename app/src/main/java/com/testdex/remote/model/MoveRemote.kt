package com.testdex.remote.model

import com.google.gson.annotations.SerializedName

data class MoveRemote(
    val name: String,
    val power: Int?,
    val accuracy: Int?,
    val pp: Int,
    @SerializedName("effect")
    val description: String,
    val type: String // Be careful with this
)
