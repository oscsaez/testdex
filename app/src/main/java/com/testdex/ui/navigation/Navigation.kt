package com.testdex.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.testdex.R
import com.testdex.ui.screens.pokedex.PokedexScreen
import com.testdex.ui.screens.pokedex.PokedexViewModel
import com.testdex.ui.screens.pokedex.pokemon.PokemonEvent
import com.testdex.ui.screens.pokedex.pokemon.PokemonScreen
import com.testdex.ui.screens.pokedex.pokemon.PokemonViewModel
import com.testdex.ui.screens.settings.SettingsScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val pokedexViewModel: PokedexViewModel = hiltViewModel()
    val pokedexState by pokedexViewModel.state.collectAsState()

    val pokemonViewModel: PokemonViewModel = hiltViewModel()
    val pokemonState by pokemonViewModel.state.collectAsState()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TestdexScreen.TestdexPokedexScreen.route
    ) {
        composable(TestdexScreen.TestdexPokedexScreen.route) {
            PokedexScreen(
                state = pokedexState
            ) { pokedexOrder ->
                navController.navigate(TestdexScreen.TestdexPokemonScreen.createRoute(pokedexOrder))
            }
        }
        composable(
            route = TestdexScreen.TestdexPokemonScreen.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")

            LaunchedEffect(key1 = Unit) {
                name?.let {
                    pokemonViewModel.onEvent(PokemonEvent.RetrievePokemon(it))
                }
            }

            PokemonScreen(
                loading = pokemonState.loading,
                pokemon = pokemonState.pokemon
            ) {
                // TODO Add to favorite pokemon
            }
        }
        composable(TestdexScreen.TestdexTableTypesScreen.route) {
            // TODO Remove toast and call TableTypesScreen
            val context = LocalContext.current

            LaunchedEffect(key1 = Unit) {
                Toast.makeText(
                    context,
                    context.getString(R.string.development_in_progress_text),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        composable(TestdexScreen.TestdexFavoritesScreen.route) {
            // TODO Remove toast and call FavoritesScreen
            val context = LocalContext.current

            LaunchedEffect(key1 = Unit) {
                Toast.makeText(
                    context,
                    context.getString(R.string.development_in_progress_text),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        composable(TestdexScreen.TestdexSettingsScreen.route) {
            SettingsScreen()
        }
    }
}