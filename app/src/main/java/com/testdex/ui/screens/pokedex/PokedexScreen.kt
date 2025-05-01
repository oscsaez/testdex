package com.testdex.ui.screens.pokedex

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.testdex.R
import com.testdex.ui.composables.TestdexCircularProgressIndicator
import com.testdex.ui.composables.TestdexHorizontalDivider
import com.testdex.ui.composables.TestdexSearchTopBar
import com.testdex.ui.model.PokemonBasicsUIModel

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    state: PokedexState,
    onPokemonClick: (String) -> Unit
) {
    val context = LocalContext.current
    val listState = rememberLazyListState()
    var filteredPokemonList by remember { mutableStateOf(state.pokemonList) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TestdexSearchTopBar(
                rightActions = {
                    IconButton(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.regular_padding)),
                        onClick = {
                            // TODO Open filters
                            Toast.makeText(
                                context,
                                context.getString(R.string.development_in_progress_text),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = "Filter icon",
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                },
                onAppIconButtonClick = {
                    // TODO Reset all filters and search?
                    Toast.makeText(
                        context,
                        context.getString(R.string.development_in_progress_text),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) { input ->
                filteredPokemonList = searchByPokedexOrderOrNameOrType(
                    context,
                    input,
                    state.pokemonList
                )
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
                if(filteredPokemonList.isNotEmpty()) {
                    items(filteredPokemonList.size - 1) { index ->
                        PokedexItem(
                            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.regular_padding)),
                            pokemonBasics = filteredPokemonList[index]
                        ) {
                            onPokemonClick(filteredPokemonList[index].name)
                        }
                        TestdexHorizontalDivider()
                    }
                    item {
                        PokedexItem(
                            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.regular_padding)),
                            pokemonBasics = filteredPokemonList.last()
                        ) {
                            onPokemonClick(filteredPokemonList.last().name)
                        }
                    }
                }
            }
        }
    }
}

private fun searchByPokedexOrderOrNameOrType(
    context: Context,
    input: String,
    pokemonList: List<PokemonBasicsUIModel>
): List<PokemonBasicsUIModel> {
    val lowerCaseInput = input.lowercase()

    return pokemonList.filter { pokemon ->
        pokemon.name.lowercase().startsWith(lowerCaseInput) ||
        pokemon.pokedexOrder.toString().startsWith(lowerCaseInput) ||
        pokemon.types.any { type ->
            context.getString(type.nameResId).lowercase().startsWith(lowerCaseInput)
        }
    }
}