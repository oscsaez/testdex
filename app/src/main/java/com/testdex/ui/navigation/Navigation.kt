package com.testdex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.screens.pokedex.PokedexScreen
import com.testdex.ui.screens.pokedex.pokemon.PokemonScreen
import com.testdex.ui.screens.settings.SettingsScreen
import com.testdex.ui.utils.mockedPokemonList

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // TODO View model call
    val pokemonList: List<PokemonUIModel> by remember { mutableStateOf(mockedPokemonList()) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TestdexScreen.TestdexPokedexScreen.route
    ) {
        composable(TestdexScreen.TestdexPokedexScreen.route) {
            PokedexScreen(
                pokemonList = pokemonList
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
                pokemon = pokemonList.first { it.pokedexOrder == pokedexOrder }
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