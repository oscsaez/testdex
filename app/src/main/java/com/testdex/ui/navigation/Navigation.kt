package com.testdex.ui.navigation

import androidx.compose.runtime.Composable
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
import com.testdex.ui.screens.pokedex.pokemon.PokemonScreen
import com.testdex.ui.screens.settings.SettingsScreen
import com.testdex.ui.utils.mockedPokemonList

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val pokedexViewModel: PokedexViewModel = hiltViewModel()
    val pokedexState by pokedexViewModel.state.collectAsState()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TestdexScreen.TestdexPokedexScreen.route
    ) {
        composable(TestdexScreen.TestdexPokedexScreen.route) {
            PokedexScreen(
                state = pokedexState
            ) { pokemonOrder ->
                navController.navigate(TestdexScreen.TestdexPokemonScreen.createRoute(pokemonOrder))
            }
        }
        composable(
            route = TestdexScreen.TestdexPokemonScreen.route,
            arguments = listOf(navArgument("pokedexOrder") { type = NavType.IntType })
        ) { backStackEntry ->
            val pokedexOrder = backStackEntry.arguments?.getInt("pokedexOrder")
            PokemonScreen(
                pokemon = mockedPokemonList().first { it.pokedexOrder == pokedexOrder }
            ) {
                // TODO
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