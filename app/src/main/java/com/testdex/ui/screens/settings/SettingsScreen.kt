package com.testdex.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.testdex.R
import com.testdex.ui.composables.TestdexTitleTopBar
import com.testdex.ui.theme.Dark
import com.testdex.ui.theme.Light

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val state by settingsViewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TestdexTitleTopBar(title = stringResource(id = R.string.settings_screen_title))
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.screen_padding))
        ) {
            SettingsItem(
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.regular_padding))
                    .padding(bottom = dimensionResource(id = R.dimen.regular_padding)),
                title = if(state.isDarkTheme) stringResource(id = R.string.dark_theme_text)
                    else stringResource(id = R.string.light_theme_text)
            ) {
                Switch(
                    checked = state.isDarkTheme,
                    onCheckedChange = { dark ->
                        settingsViewModel.updateIsDarkTheme(dark)
                    },
                    thumbContent = {
                        if(state.isDarkTheme) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_moon),
                                contentDescription = "Dark theme icon"
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_sun),
                                contentDescription = "Light theme icon"
                            )
                        }
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Dark,
                        checkedBorderColor = Light,
                        checkedIconColor = Light,
                        checkedTrackColor = Dark,
                        uncheckedThumbColor = Light,
                        uncheckedBorderColor = Dark,
                        uncheckedIconColor = Dark,
                        uncheckedTrackColor = Light
                    )
                )
            }
            SettingsDivider()
            SettingsItem(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.screen_padding)),
                title = stringResource(id = R.string.colors_theme_text)
            ) {
                SettingsThemeColorsList(
                    colors = state.colors,
                    selectedColor = state.themeColor
                ) { color ->
                    settingsViewModel.updateColorTheme(color)
                }
            }
        }
    }
}