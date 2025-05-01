package com.testdex.ui.screens.pokedex.pokemon.moves

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.testdex.R
import com.testdex.ui.composables.AccordionItem
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.model.MoveUIModel

@Composable
fun PokemonMovesList(
    modifier: Modifier = Modifier,
    moves: List<MoveUIModel>
) {
    Column(
        modifier = modifier
    ) {
        PokemonMovesListHeader()
        moves.forEach { move ->
            AccordionItem(
                titleContent = { titleContentModifier ->
                    PokemonMoveItem(
                        modifier = titleContentModifier,
                        move = move
                    )
                    if(move.name != moves.last().name) {
                        TestdexHorizontalDivider()
                    }
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = dimensionResource(id = R.dimen.big_regular_padding),
                            start = dimensionResource(id = R.dimen.screen_padding),
                            end = dimensionResource(id = R.dimen.section_padding),
                            bottom = dimensionResource(id = R.dimen.screen_padding)
                        ),
                    text = move.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}