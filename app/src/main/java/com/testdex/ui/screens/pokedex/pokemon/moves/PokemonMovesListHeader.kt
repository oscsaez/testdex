package com.testdex.ui.screens.pokedex.pokemon.moves

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.testdex.R
import com.testdex.ui.composables.TestdexVerticalDivider
import com.testdex.ui.theme.Gray

@Composable
fun PokemonMovesListHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.stat_header_height))
            .border(
                width = dimensionResource(id = R.dimen.divider_thickness),
                color = Gray,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.stat_indicator_corner_radius))
            )
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(2.6f)
                .padding(start = dimensionResource(id = R.dimen.screen_padding)),
            text = stringResource(id = R.string.move_name_text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        TestdexVerticalDivider()
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.type_text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        TestdexVerticalDivider()
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.move_pp_text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        TestdexVerticalDivider()
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.move_power_text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        TestdexVerticalDivider()
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.move_accuracy_text),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}