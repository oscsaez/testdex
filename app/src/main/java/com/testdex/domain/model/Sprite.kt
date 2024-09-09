package com.testdex.domain.model

data class Sprite(
    val officialArtworkURI: String,
    val backMaleURI: String,
    val backFemaleURI: String?,
    val backShinyMaleURI: String,
    val backShinyFemaleURI: String?,
    val frontMaleURI: String,
    val frontFemaleURI: String?,
    val frontShinyMaleURI: String,
    val frontShinyFemaleURI: String?
)
