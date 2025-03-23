package com.testdex.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.testdex.ui.screens.pokedex.PokedexScreen
import com.testdex.ui.screens.pokedex.PokedexViewModel
import com.testdex.ui.screens.pokedex.pokemon.PokemonEvent
import com.testdex.ui.screens.pokedex.pokemon.PokemonScreen
import com.testdex.ui.screens.pokedex.pokemon.PokemonViewModel
import com.testdex.ui.screens.settings.SettingsScreen

// TODO Remove this SuppressLint when retrieve real pokemon data
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
            arguments = listOf(navArgument("pokedexOrder") { type = NavType.IntType })
        ) { backStackEntry ->
            val pokedexOrder = backStackEntry.arguments?.getInt("pokedexOrder")

            LaunchedEffect(key1 = Unit) {
                pokedexOrder?.let {
                    pokemonViewModel.onEvent(PokemonEvent.RetrievePokemon(it))
                }
            }

            pokemonState.pokemon?.let {
                PokemonScreen(
                    loading = pokemonState.loading,
                    pokemon = it
                ) {
                    // TODO Add to favorite pokemon
                }
            }
        }
        composable(TestdexScreen.TestdexTableTypesScreen.route) {
            /*TODO*/
        }
        composable(TestdexScreen.TestdexFavoritesScreen.route) {
            /*TODO*/
        }
        composable(TestdexScreen.TestdexSettingsScreen.route) {
            SettingsScreen()
        }
    }
}