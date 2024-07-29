package com.testdex.ui.screens.pokedex

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.testdex.R
import com.testdex.ui.model.PokemonUIModel

@Composable
fun PokedexItem(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border)))
            .clickable { onCardClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.zero)
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.screen_padding)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = pokemon.pokedexOrder.toString(),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            LazyRow {
                items(count = pokemon.types.size) { index ->
                    Icon(
                        painter = painterResource(id = pokemon.types[index].imageResId),
                        contentDescription = "${pokemon.types[index].name} type icon"
                    )
                }
            }
        }
    }
}