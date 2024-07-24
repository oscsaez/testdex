package com.testdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import com.testdex.ui.TestdexScaffold
import com.testdex.ui.managers.UserPreferences
import com.testdex.ui.model.ThemeColor
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

        setContent {
            TestdexTheme(
                darkTheme = darkThemeState,
                theme = themeColorState
            ) {
                TestdexScaffold()
            }
        }
    }
}