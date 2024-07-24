package com.testdex.ui.model

import androidx.compose.ui.graphics.Color
import com.testdex.ui.theme.Blue
import com.testdex.ui.theme.Red
import com.testdex.ui.theme.Yellow

sealed class ThemeColor(
    val name: String,
    val color: Color
) {
    object RedTheme: ThemeColor("Red", Red)
    object BlueTheme: ThemeColor("Blue", Blue)
    object YellowTheme: ThemeColor("Yellow", Yellow)
}