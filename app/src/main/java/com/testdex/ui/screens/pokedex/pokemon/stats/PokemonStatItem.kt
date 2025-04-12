package com.testdex.ui.screens.pokedex.pokemon.stats

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.testdex.R
import com.testdex.ui.composables.GradientLinearProgressIndicator
import com.testdex.ui.model.StatUIModel
import com.testdex.ui.utils.UIConstants

@Composable
fun PokemonStatItem(
    modifier: Modifier = Modifier,
    stat: StatUIModel,
    brush: Brush
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (nameRef, baseRef, indicatorRef) = createRefs()
        val leftGuideline = createGuidelineFromStart(0.2f)
        val middleGuideline = createGuidelineFromStart(0.29f)
        val rightGuideline = createGuidelineFromStart(0.33f)

        Text(
            modifier = Modifier.constrainAs(nameRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(leftGuideline)
            },
            text = stat.name,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            modifier = Modifier.constrainAs(baseRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(middleGuideline)
            },
            text = stat.base.toString(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        GradientLinearProgressIndicator(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.stat_indicator_length))
                .height(dimensionResource(id = R.dimen.stat_indicator_thickness))
                .constrainAs(indicatorRef) {
                    start.linkTo(rightGuideline)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.stat_indicator_corner_radius))),
            progress = stat.base / UIConstants.MAX_TOTAL_STATS_NUMBER,
            brush = brush,
            trackColor = MaterialTheme.colorScheme.primaryContainer,
        )
    }
}