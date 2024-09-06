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
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.testdex.R
import com.testdex.ui.composables.TestdexCircularProgressIndicator
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.composables.TestdexSearchTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    state: PokedexState,
    onLoadMorePokemon: () -> Unit,
    onPokemonClick: (Int) -> Unit
) {
    val listState = rememberLazyListState()

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
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            TestdexCircularProgressIndicator()
                        }
                    }
                }
            }

            // Load more pokemon when the end of the list has been reached
            LaunchedEffect(key1 = listState) {
                snapshotFlow {
                    // Check that the content is bigger than the size available
                    listState.layoutInfo.totalItemsCount > 0 && listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == state.pokemonList.size - 1
                }.collect { canScrollToEnd ->
                    if (canScrollToEnd && listState.layoutInfo.visibleItemsInfo.size < listState.layoutInfo.totalItemsCount) {
                        onLoadMorePokemon()
                    }
                }
            }
        }
    }
}