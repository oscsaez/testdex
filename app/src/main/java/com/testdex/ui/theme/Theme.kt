package com.testdex.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.testdex.ui.model.ThemeColor

// -------- Dark themes --------
private val DarkRedColorScheme = darkColorScheme(
    primary = Red,
    onPrimary = Light,
    primaryContainer = DarkGray,
    secondary = Gray,
    background = Dark,
    onBackground = Light
)

private val DarkBlueColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = Light,
    primaryContainer = DarkGray,
    secondary = Gray,
    background = Dark,
    onBackground = Light
)

private val DarkYellowColorScheme = darkColorScheme(
    primary = Yellow,
    onPrimary = Light,
    primaryContainer = DarkGray,
    secondary = Gray,
    background = Dark,
    onBackground = Light
)

// -------- Light themes --------
private val LightRedColorScheme = lightColorScheme(
    primary = Red,
    onPrimary = Light,
    primaryContainer = LightGray,
    secondary = Gray,
    background = Light,
    onBackground = Dark
)

private val LightBlueColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = Light,
    primaryContainer = LightGray,
    secondary = Gray,
    background = Light,
    onBackground = Dark
)

private val LightYellowColorScheme = lightColorScheme(
    primary = Yellow,
    onPrimary = Light,
    primaryContainer = LightGray,
    secondary = Gray,
    background = Light,
    onBackground = Dark
)

@Composable
fun TestdexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    theme: ThemeColor = ThemeColor.RedTheme,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> themeSelected(darkTheme, theme)
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

fun themeSelected(darkTheme: Boolean, theme: ThemeColor) = when(darkTheme) {
    true -> when(theme) {
        ThemeColor.RedTheme -> DarkRedColorScheme
        ThemeColor.BlueTheme -> DarkBlueColorScheme
        ThemeColor.YellowTheme -> DarkYellowColorScheme
    }
    false -> when(theme) {
        ThemeColor.RedTheme -> LightRedColorScheme
        ThemeColor.BlueTheme -> LightBlueColorScheme
        ThemeColor.YellowTheme -> LightYellowColorScheme
    }
}