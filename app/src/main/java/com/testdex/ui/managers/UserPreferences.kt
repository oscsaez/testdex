package com.testdex.ui.managers

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.testdex.ui.model.ThemeColor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class UserPreferences(context: Context) {
    private val dataStore = context.dataStore
    private val THEME_BRIGHTNESS_KEY = booleanPreferencesKey("theme_brightness")
    private val THEME_COLOR_KEY = stringPreferencesKey("theme_color")

    val themeDark: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[THEME_BRIGHTNESS_KEY] ?: false
    }

    val themeColor: Flow<ThemeColor> = dataStore.data.map { preferences ->
        val themeColorValue = preferences[THEME_COLOR_KEY] ?: ThemeColor.Red.name
        ThemeColor.valueOf(themeColorValue)
    }

    suspend fun setThemeBrightness(themeBrightness: Boolean) {
        dataStore.edit { settings ->
            settings[THEME_BRIGHTNESS_KEY] = themeBrightness
        }
    }

    suspend fun setThemeColor(themeColor: ThemeColor) {
        dataStore.edit { settings ->
            settings[THEME_COLOR_KEY] = themeColor.name
        }
    }
}