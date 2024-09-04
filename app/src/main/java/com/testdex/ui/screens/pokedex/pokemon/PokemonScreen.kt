package com.testdex.ui.screens.pokedex.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.testdex.R
import com.testdex.ui.composables.TestdexTitleTopBar
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.screens.pokedex.pokemon.moves.PokemonMovesList
import com.testdex.ui.screens.pokedex.pokemon.stats.PokemonStatsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel,
    onFavoritesClick: () -> Unit
) {
    // TODO Real implementation
    var isFavorite: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TestdexTitleTopBar(
                title = pokemon.name,
                actions = {
                    IconButton(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.regular_padding)),
                        onClick = {
                            // TODO Real implementation
                            isFavorite = !isFavorite
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "Favorite icon",
                            tint = if(isFavorite)
                                MaterialTheme.colorScheme.onBackground
                            else
                                MaterialTheme.colorScheme.background
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
           item {
               Column(
                   modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_padding))
               ) {
                   PokemonInfoCard(
                       modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.section_padding)),
                       pokemon = pokemon
                   )
                   Text(
                       text = stringResource(id = R.string.stats_text),
                       style = MaterialTheme.typography.titleLarge,
                       color = MaterialTheme.colorScheme.onBackground,
                       fontWeight = FontWeight.Bold
                   )
                   PokemonStatsList(
                       modifier = Modifier
                           .padding(top = dimensionResource(id = R.dimen.regular_padding))
                           .padding(bottom = dimensionResource(id = R.dimen.section_padding)),
                       stats = pokemon.stats,
                       typeColor = pokemon.types.first().color
                   )
                   Text(
                       text = stringResource(id = R.string.moves_text),
                       style = MaterialTheme.typography.titleLarge,
                       color = MaterialTheme.colorScheme.onBackground,
                       fontWeight = FontWeight.Bold
                   )
                   PokemonMovesList(
                       modifier = Modifier
                           .padding(top = dimensionResource(id = R.dimen.regular_padding)),
                       moves = pokemon.moves,
                   )
               }
           }
        }
    }
}