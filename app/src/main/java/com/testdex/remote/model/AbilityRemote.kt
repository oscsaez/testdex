package com.testdex.remote.model

import com.google.gson.annotations.SerializedName

data class AbilityRemote(
    val name: String,
    @SerializedName("effect")
    val description: String,
    @SerializedName("is_hidden")
    val isHidden: Boolean
)
