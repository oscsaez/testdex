package com.testdex.ui.screens.pokedex.pokemon

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.testdex.R
import com.testdex.ui.composables.TestdexDivider
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.theme.Gray

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel
) {

    val context = LocalContext.current
    
    @Composable
    fun InfoRow(
        modifier: Modifier = Modifier,
        @StringRes titleResId: Int,
        info: String
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = context.getString(
                    R.string.two_points_format,
                    stringResource(id = titleResId)
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = info,
                style = MaterialTheme.typography.bodyMedium,
                color = Gray
            )
        }
    }
    
    Card(
        modifier = modifier,
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
        Column {
            AsyncImage(
                model = pokemon.sprite.officialArtworkURI,
                contentDescription = "${pokemon.name} official artwork"
            )
            TestdexDivider(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
            )
            InfoRow(
                titleResId = R.string.pokedex_number_text,
                info = pokemon.pokedexOrder.toString()
            )
            TestdexDivider(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
            )
            // TODO Types
            pokemon.abilities.find { !it.isHidden }?.let {
                InfoRow(titleResId = R.string.ability_text, info = it.name)
            }
            TestdexDivider(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
            )
            pokemon.abilities.find { it.isHidden }?.let {
                InfoRow(titleResId = R.string.hidden_ability_text, info = it.name)
            }
            TestdexDivider(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
            )
            InfoRow(
                titleResId = R.string.height_text,
                info = pokemon.height.toString()
            )
            TestdexDivider(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
            )
            InfoRow(
                titleResId = R.string.weight_text,
                info = pokemon.weight.toString()
            )
        }
    }
}