package com.testdex.remote.model

import com.google.gson.annotations.SerializedName

data class StatRemote(
    val name: String, // Be careful with this
    @SerializedName("base_stat")
    val base: Int
)
