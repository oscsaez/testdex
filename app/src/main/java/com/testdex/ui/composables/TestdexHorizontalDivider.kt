package com.testdex.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.testdex.R

@Composable
fun TestdexHorizontalDivider(
    modifier: Modifier = Modifier
) {
    Divider(
        modifier = modifier.fillMaxWidth(),
        thickness = dimensionResource(id = R.dimen.divider_thickness),
        color = MaterialTheme.colorScheme.secondary
    )
}