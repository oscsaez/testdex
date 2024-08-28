package com.testdex.ui.model

data class MoveUIModel(
    val name: String,
    val power: Int,
    val accuracy: Int,
    val pp: Int,
    val description: String,
    val type: TypeUIModel
)
