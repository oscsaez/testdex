package com.testdex.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.testdex.ui.screens.pokedex.pokemon.PokemonScreen
import com.testdex.ui.screens.settings.SettingsScreen
import com.testdex.ui.utils.mockedPokemonList
import kotlinx.coroutines.launch

// TODO Remove this SuppressLint when retrieve real pokemon data
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val pokedexViewModel: PokedexViewModel = hiltViewModel()
    val pokedexState by pokedexViewModel.state.collectAsState()

    // TODO Remove when retrieve real pokemon data
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TestdexScreen.TestdexPokedexScreen.route
    ) {
        composable(TestdexScreen.TestdexPokedexScreen.route) {
            val context = LocalContext.current

            // TODO Remove this Scaffold when retrieve real pokemon data
            Scaffold(
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
            ) {
                PokedexScreen(
                    state = pokedexState
                ) { pokedexOrder ->

                    // TODO Remove toast and call use case when create it to retrieve real pokemon data
                    if(pokedexOrder == 1) {
                        navController.navigate(TestdexScreen.TestdexPokemonScreen.createRoute(pokedexOrder))
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = context.getString(R.string.not_implemented_text)
                            )
                        }
                    }
                }
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
                // TODO Add to favorite pokemon
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