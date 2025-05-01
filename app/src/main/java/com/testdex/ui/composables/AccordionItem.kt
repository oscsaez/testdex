package com.testdex.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun AccordionItem(
    modifier: Modifier = Modifier,
    titleContent: @Composable (Modifier) -> Unit,
    descriptionContent: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        titleContent(
            Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
        )
        
        AnimatedVisibility(visible = expanded) {
            descriptionContent()
        }
    }
}