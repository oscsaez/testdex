package com.testdex.ui.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.testdex.R

@Composable
fun roundedTopBordersShape(): Shape = RoundedCornerShape(
    topStart = dimensionResource(id = R.dimen.rounded_border),
    topEnd = dimensionResource(id = R.dimen.rounded_border)
)

@Composable
fun roundedBottomBordersShape(): Shape = RoundedCornerShape(
    bottomStart = dimensionResource(id = R.dimen.rounded_border),
    bottomEnd = dimensionResource(id = R.dimen.rounded_border)
)