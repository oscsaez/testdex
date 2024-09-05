package com.testdex.ui.composables

import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.testdex.R

@Composable
fun TestdexCircularProgressIndicator(
    modifier: Modifier = Modifier,
) {
    CircularProgressIndicator(
        modifier = modifier.width(dimensionResource(id = R.dimen.circular_progress_indicator_size)),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = dimensionResource(id = R.dimen.circular_progress_indicator_width)
    )
}