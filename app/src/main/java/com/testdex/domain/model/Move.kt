package com.testdex.domain.model

data class Move(
    val name: String,
    val power: Int?,
    val accuracy: Int?,
    val pp: Int,
    val description: String,
    val type: String
)
