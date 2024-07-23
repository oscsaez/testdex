package com.testdex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TestdexScreen.TestdexPokedexScreen.route
    ) {
        composable(TestdexScreen.TestdexPokedexScreen.route) {
            /*TODO*/
        }
        composable(TestdexScreen.TestdexTableTypesScreen.route) {
            /*TODO*/
        }
        composable(TestdexScreen.TestdexFavoritesScreen.route) {
            /*TODO*/
        }
        composable(TestdexScreen.TestdexSettingsScreen.route) {
            /*TODO*/
        }
    }
}