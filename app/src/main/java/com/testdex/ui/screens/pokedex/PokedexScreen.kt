package com.testdex.ui.screens.pokedex

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.testdex.R
import com.testdex.ui.composables.TestdexDivider
import com.testdex.ui.composables.TestdexSearchTopBar
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.utils.mockedPokemonList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    onPokemonClick: (PokemonUIModel) -> Unit
) {
    val pokemonList: List<PokemonUIModel> = mockedPokemonList()

    Scaffold(
        modifier = modifier,
        topBar = {
            TestdexSearchTopBar(
                rightActions = {
                    IconButton(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.regular_padding)),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = "Filter icon",
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                },
                onAppIconButtonClick = { /*TODO*/ }
            ) {
                // TODO
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.screen_padding))
        ) {
            items(pokemonList.size - 1) { index ->
                PokedexItem(
                    modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.regular_padding)),
                    pokemon = pokemonList[index]
                ) {
                    onPokemonClick(pokemonList[index])
                }
                TestdexDivider()
            }
            item {
                PokedexItem(
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.regular_padding)),
                    pokemon = pokemonList.last()
                ) {
                    onPokemonClick(pokemonList.last())
                }
            }
        }
    }
}