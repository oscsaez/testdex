package com.testdex.ui.screens.pokedex.pokemon.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import com.testdex.R
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.model.StatUIModel

@Composable
fun PokemonStatsList(
    modifier: Modifier = Modifier,
    stats: List<StatUIModel>,
    typesBrush: Brush
) {
    Column(
        modifier = modifier
    ) {
        stats.forEach { stat ->
            PokemonStatItem(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.regular_padding)),
                stat = stat,
                brush = typesBrush
            )
            if(stat.name != stats.last().name) {
                TestdexHorizontalDivider()
            }
        }
    }
}