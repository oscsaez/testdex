package com.testdex.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class TypeUIModel(
    @StringRes val nameResId: Int,
    @DrawableRes val imageResId: Int,
    val color: Color
)