package com.testdex.ui.screens.pokedex.pokemon.moves

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            PokemonMoveItem(move = move)
            if(move.name != moves.last().name) {
                TestdexHorizontalDivider()
            }
        }
    }
}