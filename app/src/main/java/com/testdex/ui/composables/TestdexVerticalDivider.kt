package com.testdex.ui.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.testdex.R

@Composable
fun TestdexVerticalDivider(
    modifier: Modifier = Modifier
) {
    Divider(
        modifier = modifier
            .fillMaxHeight()
            .width(dimensionResource(id = R.dimen.divider_thickness)),
        color = MaterialTheme.colorScheme.secondary
    )
}