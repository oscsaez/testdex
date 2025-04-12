package com.testdex.ui.screens.pokedex.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.testdex.ui.composables.TestdexLoadingBox
import com.testdex.ui.composables.TestdexTitleTopBar
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.screens.pokedex.pokemon.moves.PokemonMovesList
import com.testdex.ui.screens.pokedex.pokemon.stats.PokemonStatsList
import com.testdex.ui.utils.gradient
import com.testdex.utils.replaceGenderSymbols
import com.testdex.utils.toTitleCaseWithoutHyphen

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    loading: Boolean,
    pokemon: PokemonUIModel?,
    onFavoritesClick: () -> Unit
) {
    if (loading && pokemon == null) {
        TestdexLoadingBox()
    } else {
        pokemon?.let { loadedPokemon ->
            // TODO Real implementation
            var isFavorite: Boolean by remember { mutableStateOf(false) }

            Scaffold(
                modifier = modifier,
                topBar = {
                    TestdexTitleTopBar(
                        title = loadedPokemon.name
                            .replaceGenderSymbols()
                            .toTitleCaseWithoutHyphen(),
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
                                pokemon = loadedPokemon
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
                                stats = loadedPokemon.stats,
                                typesBrush = gradient(pokemon.types.map { it.color })
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
                                moves = loadedPokemon.moves,
                            )
                        }
                    }
                }
            }
        }
    }
}