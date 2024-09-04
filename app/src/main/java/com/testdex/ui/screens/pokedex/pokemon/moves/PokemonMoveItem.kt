package com.testdex.ui.screens.pokedex.pokemon.moves

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.testdex.R
import com.testdex.ui.model.MoveUIModel
import com.testdex.ui.theme.Gray

@Composable
fun PokemonMoveItem(
    modifier: Modifier = Modifier,
    move: MoveUIModel
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(2.6f)
                .padding(start = dimensionResource(id = R.dimen.screen_padding)),
            text = move.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Image(
            painter = painterResource(id = move.type.imageResId),
            contentDescription = "${move.type.name} type icon"
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.regular_padding)),
            text = move.pp.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = Gray,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.regular_padding)),
            text = move.power?.toString() ?: run {
                stringResource(id = R.string.no_number_text)
            },
            style = MaterialTheme.typography.bodyMedium,
            color = Gray,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.regular_padding)),
            text = move.accuracy?.toString() ?: run {
                stringResource(id = R.string.no_number_text)
            },
            style = MaterialTheme.typography.bodyMedium,
            color = Gray,
            textAlign = TextAlign.Center
        )
    }
}