package com.testdex.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.testdex.R

@Composable
fun GradientLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    brush: Brush,
    trackColor: Color = Color.LightGray,
    height: Dp = 4.dp
) {
    Box(
        modifier = modifier
            .height(height)
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border)))
            .background(trackColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(fraction = progress.coerceIn(0f, 1f))
                .background(brush = brush)
        )
    }
}