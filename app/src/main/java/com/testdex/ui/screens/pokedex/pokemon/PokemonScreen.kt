package com.testdex.ui.screens.pokedex.pokemon

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.testdex.R
import com.testdex.ui.composables.TestdexTitleTopBar
import com.testdex.ui.model.PokemonUIModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel,
    onFavoritesClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TestdexTitleTopBar(title = pokemon.name)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.screen_padding))
        ) {
           item {
               PokemonCard(
                   pokemon = pokemon
               )
           }
        }
    }
}