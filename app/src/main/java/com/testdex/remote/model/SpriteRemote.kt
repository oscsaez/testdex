package com.testdex.remote.model

import com.google.gson.annotations.SerializedName

data class SpriteRemote(
    @SerializedName("official-artwork") // Be careful with this
    val officialArtworkURI: String,
    @SerializedName("back_default")
    val backMaleURI: String,
    @SerializedName("back_female")
    val backFemaleURI: String,
    @SerializedName("back_shiny")
    val backShinyMaleURI: String,
    @SerializedName("back_shiny_female")
    val backShinyFemaleURI: String,
    @SerializedName("front_default")
    val frontMaleURI: String,
    @SerializedName("front_female")
    val frontFemaleURI: String,
    @SerializedName("front_shiny")
    val frontShinyMaleURI: String,
    @SerializedName("front_shiny_female")
    val frontShinyFemaleURI: String
)
