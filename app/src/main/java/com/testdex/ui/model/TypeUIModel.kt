package com.testdex.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class TypeUIModel(
    val name: String,
    @DrawableRes val imageResId: Int,
    val color: Color
)