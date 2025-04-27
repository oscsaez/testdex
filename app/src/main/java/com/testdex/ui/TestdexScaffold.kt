package com.testdex.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.testdex.ui.composables.NoNetworkConnectionDialog
import com.testdex.ui.composables.TestdexBottomBar
import com.testdex.ui.navigation.Navigation
import com.testdex.ui.navigation.TestdexScreen
import com.testdex.ui.utils.navigateWithoutStack

val screens: List<TestdexScreen> = listOf(
    TestdexScreen.TestdexPokedexScreen,
    TestdexScreen.TestdexTableTypesScreen,
    TestdexScreen.TestdexFavoritesScreen,
    TestdexScreen.TestdexSettingsScreen
)

@Composable
fun TestdexScaffold(
    modifier: Modifier = Modifier,
    isConnected: Boolean
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            TestdexBottomBar(
                elements = screens,
                onElementClick = { screen ->
                    navController.navigateWithoutStack(screen.route)
                }
            )
        }
    ) { innerPadding ->
        Navigation(
            modifier = Modifier.padding(innerPadding),
            navController = navController
        )

        if (!isConnected) {
            NoNetworkConnectionDialog()
        }
    }
}