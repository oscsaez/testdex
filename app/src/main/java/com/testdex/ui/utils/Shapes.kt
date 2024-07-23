package com.testdex.ui.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

fun roundedTopBordersShape(): Shape {
    return RoundedCornerShape(
        topStart = 28.dp,
        topEnd = 28.dp
    )
}