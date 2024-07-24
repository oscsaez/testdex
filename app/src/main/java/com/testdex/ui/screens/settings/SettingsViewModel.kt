package com.testdex.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.ui.managers.UserPreferences
import com.testdex.ui.model.ThemeColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val isDarkTheme: Boolean = false,
    val themeColor: ThemeColor = ThemeColor.RedTheme,
    val colors: List<ThemeColor> = emptyList()
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        getIsDarkTheme()
        getThemeColor()
        getColors()
    }

    private fun getIsDarkTheme() {
        viewModelScope.launch {
            userPreferences.themeDark.collect { dark ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isDarkTheme = dark
                    )
                }
            }
        }
    }

    private fun getThemeColor() {
        viewModelScope.launch {
            userPreferences.themeColor.collect { color ->
                _uiState.update { currentState ->
                    currentState.copy(
                        themeColor = color
                    )
                }
            }
        }
    }

    // TODO Change this to a real implementation
    private fun getColors() {
        _uiState.update { currentState ->
            currentState.copy(
                colors = listOf(
                    ThemeColor.RedTheme,
                    ThemeColor.BlueTheme,
                    ThemeColor.YellowTheme
                )
            )
        }
    }

    fun updateIsDarkTheme(isDarkTheme: Boolean) {
        viewModelScope.launch {
            userPreferences.setThemeBrightness(isDarkTheme)
        }
    }

    fun updateColorTheme(themeColor: ThemeColor) {
        viewModelScope.launch {
            userPreferences.setThemeColor(themeColor)
        }
    }
}