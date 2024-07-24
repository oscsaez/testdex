package com.testdex.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.testdex.R
import com.testdex.ui.model.ThemeColor

@Composable
fun SettingsThemeColorsList(
    modifier: Modifier = Modifier,
    colors: List<ThemeColor>,
    selectedColor: ThemeColor,
    onColorClick: (ThemeColor) -> Unit
) {

    @Composable
    fun ThemeColorBox(
        modifier: Modifier = Modifier,
        color: ThemeColor
    ) {
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = if(color.name == selectedColor.name)
                    MaterialTheme.colorScheme.onBackground
                else
                    MaterialTheme.colorScheme.background
            ),
            onClick = {
                onColorClick(color)
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.color_circle_size))
                        .clip(CircleShape)
                        .background(color.color)
                        .border(
                            width = dimensionResource(id = R.dimen.color_circle_thickness),
                            color = if(color.name == selectedColor.name)
                                MaterialTheme.colorScheme.background
                            else
                                MaterialTheme.colorScheme.onBackground,
                            shape = CircleShape
                        )
                )
                Text(
                    text = color.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if(color.name == selectedColor.name) MaterialTheme.colorScheme.background
                        else MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }

    LazyRow(
        modifier = modifier
    ) {
        item {
            ThemeColorBox(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.regular_padding)),
                color = colors.first()
            )
        }
        items(colors.size-2) { index ->
            ThemeColorBox(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.regular_padding)),
                color = colors[index+1]
            )
        }
        item {
            ThemeColorBox(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.regular_padding)),
                color = colors.last()
            )
        }
    }
}