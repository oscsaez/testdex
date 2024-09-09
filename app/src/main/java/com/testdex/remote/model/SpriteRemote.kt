package com.testdex.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpriteRemote(
    @SerialName("other") // Be careful with this
    val otherSprites: OtherSpritesRemote,
    @SerialName("back_default")
    val backMaleURI: String,
    @SerialName("back_female")
    val backFemaleURI: String?,
    @SerialName("back_shiny")
    val backShinyMaleURI: String,
    @SerialName("back_shiny_female")
    val backShinyFemaleURI: String?,
    @SerialName("front_default")
    val frontMaleURI: String,
    @SerialName("front_female")
    val frontFemaleURI: String?,
    @SerialName("front_shiny")
    val frontShinyMaleURI: String,
    @SerialName("front_shiny_female")
    val frontShinyFemaleURI: String?
)

@Serializable
data class OtherSpritesRemote(
    @SerialName("official-artwork")
    val officialArtworkSpriteRemote: OfficialArtworkSpriteRemote
)

@Serializable
data class OfficialArtworkSpriteRemote(
    @SerialName("front_default")
    val frontMaleURI: String
)
