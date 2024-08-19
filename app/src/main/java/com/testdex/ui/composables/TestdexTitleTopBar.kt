package com.testdex.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.testdex.ui.theme.Dark
import com.testdex.ui.utils.roundedBottomBordersShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestdexTitleTopBar(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable (RowScope.() -> Unit) = {}
) {
    TopAppBar(
        modifier = modifier.clip(roundedBottomBordersShape()),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Dark
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = actions
    )
}