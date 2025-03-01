package com.testdex.ui.screens.pokedex

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.testdex.R
import com.testdex.ui.composables.TestdexCircularProgressIndicator
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.composables.TestdexSearchTopBar
import com.testdex.ui.utils.UIConstants
import com.testdex.ui.utils.reachedBottom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    state: PokedexState,
    onLoadMorePokemon: () -> Unit,
    onPokemonClick: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    val reachedBottom: Boolean by remember {
        derivedStateOf { listState.reachedBottom(UIConstants.NUMBER_OF_ITEMS_UNTIL_RELOAD) }
    }

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
        if(state.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                TestdexCircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(dimensionResource(id = R.dimen.screen_padding)),
                state = listState
            ) {
                items(state.pokemonList.size - 1) { index ->
                    PokedexItem(
                        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.regular_padding)),
                        pokemon = state.pokemonList[index]
                    ) {
                        onPokemonClick(state.pokemonList[index].pokedexOrder)
                    }
                    TestdexHorizontalDivider()
                }
                item {
                    PokedexItem(
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.regular_padding)),
                        pokemon = state.pokemonList.last()
                    ) {
                        onPokemonClick(state.pokemonList.last().pokedexOrder)
                    }
                }
                if(state.loadingMore) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = dimensionResource(id = R.dimen.screen_padding)),
                            contentAlignment = Alignment.Center
                        ) {
                            TestdexCircularProgressIndicator()
                        }
                    }
                }
            }

            // Load more pokemon when the end of the list has been reached
            LaunchedEffect(key1 = reachedBottom) {
                if(!state.loadingMore) {
                    onLoadMorePokemon()
                }
            }
        }
    }
}