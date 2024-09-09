package com.testdex.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class EffectEntryRemote(
    val effect: String,
    val language: LanguageRemote
)

@Serializable
data class LanguageRemote(
    val name: String
)
