package com.testdex.ui.screens.pokedex.pokemon

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.SubcomposeAsyncImage
import com.testdex.R
import com.testdex.ui.composables.TestdexCircularProgressIndicator
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.model.TypeUIModel
import com.testdex.ui.theme.Gray

@Composable
fun PokemonInfoCard(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel
) {
    val context = LocalContext.current

    // TODO Maybe a brush (gradient) for pokemon with two types

    @Composable
    fun InfoRow(
        modifier: Modifier = Modifier,
        @StringRes titleResId: Int,
        info: String
    ) {
        ConstraintLayout(
            modifier = modifier.fillMaxWidth(),
        ) {
            val (titleRef, infoRef) = createRefs()
            val leftGuideline = createGuidelineFromStart(0.15f)
            val rightGuideline = createGuidelineFromEnd(0.15f)
            Text(
                modifier = Modifier.constrainAs(titleRef) {
                    start.linkTo(leftGuideline)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                text = context.getString(
                    R.string.two_points_format,
                    stringResource(id = titleResId)
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                modifier = Modifier.constrainAs(infoRef) {
                    end.linkTo(rightGuideline)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                text = info,
                style = MaterialTheme.typography.bodyLarge,
                color = Gray
            )
        }
    }

    @Composable
    fun TypeRow(
        modifier: Modifier = Modifier,
        @StringRes titleResId: Int,
        typesList: List<TypeUIModel>
    ) {
        ConstraintLayout(
            modifier = modifier.fillMaxWidth(),
        ) {
            val (titleRef, typesRef) = createRefs()
            val leftGuideline = createGuidelineFromStart(0.15f)
            val rightGuideline = createGuidelineFromEnd(0.15f)
            Text(
                modifier = Modifier.constrainAs(titleRef) {
                    start.linkTo(leftGuideline)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                text = context.getString(
                    R.string.two_points_format,
                    stringResource(id = titleResId)
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            LazyRow(
                modifier = Modifier.constrainAs(typesRef) {
                    end.linkTo(rightGuideline)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            ) {
                items(count = typesList.size) { index ->
                    Image(
                        painter = painterResource(id = typesList[index].imageResId),
                        contentDescription = "${typesList[index].name} type icon"
                    )
                }
            }
        }
    }
    
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border)),
        border = BorderStroke(
            width = dimensionResource(id = R.dimen.regular_padding),
            color = pokemon.types.first().color
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.zero)
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.screen_padding))
                .padding(vertical = dimensionResource(id = R.dimen.regular_padding))
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = pokemon.sprite.officialArtworkURI,
                contentDescription = "${pokemon.name} official artwork",
                alignment = Alignment.Center,
                loading = { TestdexCircularProgressIndicator() }
            )
            TestdexHorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding),
                    vertical = dimensionResource(id = R.dimen.regular_padding)
                )
            )
            InfoRow(
                titleResId = R.string.pokedex_number_text,
                info = pokemon.pokedexOrder.toString()
            )
            TestdexHorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding),
                    vertical = dimensionResource(id = R.dimen.regular_padding)
                )
            )
            TypeRow(
                titleResId = R.string.types_text,
                typesList = pokemon.types
            )
            TestdexHorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding),
                    vertical = dimensionResource(id = R.dimen.regular_padding)
                )
            )
            pokemon.abilities.find { !it.isHidden }?.let {
                InfoRow(titleResId = R.string.ability_text, info = it.name)
            }
            TestdexHorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding),
                    vertical = dimensionResource(id = R.dimen.regular_padding)
                )
            )
            pokemon.abilities.find { it.isHidden }?.let {
                InfoRow(titleResId = R.string.hidden_ability_text, info = it.name)
                TestdexHorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(id = R.dimen.screen_padding),
                        vertical = dimensionResource(id = R.dimen.regular_padding)
                    )
                )
            }
            InfoRow(
                titleResId = R.string.height_text,
                info = pokemon.height.toString()
            )
            TestdexHorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding),
                    vertical = dimensionResource(id = R.dimen.regular_padding)
                )
            )
            InfoRow(
                titleResId = R.string.weight_text,
                info = pokemon.weight.toString()
            )
        }
    }
}