package com.testdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import com.testdex.ui.TestdexScaffold
import com.testdex.ui.managers.UserPreferences
import com.testdex.ui.model.ThemeColor
import com.testdex.ui.screens.pokedex.PokedexEvent
import com.testdex.ui.screens.pokedex.PokedexViewModel
import com.testdex.ui.screens.splash_screen.SplashScreen
import com.testdex.ui.theme.TestdexTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    private var darkThemeState by mutableStateOf(false)
    private var themeColorState: ThemeColor by mutableStateOf(ThemeColor.BlueTheme)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pokedexViewModel: PokedexViewModel by viewModels()

        lifecycleScope.launch {
            userPreferences.themeDark.collect { isDarkTheme ->
                darkThemeState = isDarkTheme
            }
        }
        lifecycleScope.launch {
            userPreferences.themeColor.collect { themeColor ->
                themeColorState = themeColor
            }
        }

        lifecycleScope.launch {
            pokedexViewModel.onEvent(PokedexEvent.RetrieveAllPokemonBasicsList)
        }

        setContent {
            TestdexTheme(
                darkTheme = darkThemeState,
                theme = themeColorState
            ) {
                val pokedexViewModelState by pokedexViewModel.state.collectAsState()

                if (pokedexViewModelState.loading) {
                    SplashScreen(progress = pokedexViewModelState.pokemonProgress)
                } else {
                    TestdexScaffold()
                }
            }
        }
    }
}