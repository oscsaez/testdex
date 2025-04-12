package com.testdex.ui.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private const val MINIMUM_NUMBER_OF_COLORS_FOR_GRADIENT = 2

fun gradient(colors: List<Color>): Brush {
    val gradientColors = if (colors.size < MINIMUM_NUMBER_OF_COLORS_FOR_GRADIENT) {
        listOf(colors.first(), colors.first())
    } else {
        colors
    }

    return Brush.linearGradient(
        colors = gradientColors
    )
}