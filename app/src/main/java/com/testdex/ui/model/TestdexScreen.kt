package com.testdex.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.testdex.R

sealed class TestdexScreen(
    @StringRes val name: Int,
    @DrawableRes val icon: Int
) {
    object TestdexPokedexScreen : TestdexScreen(
        name = R.string.pokedex_screen_title,
        icon = R.drawable.ic_pokeball
    )

    object TestdexTableTypesScreen : TestdexScreen(
        name = R.string.types_table_screen_title,
        icon = R.drawable.ic_table
    )

    object TestdexFavoritesScreen : TestdexScreen(
        name = R.string.favorites_screen_title,
        icon = R.drawable.ic_star
    )

    object TestdexSettingsScreen : TestdexScreen(
        name = R.string.settings_screen_title,
        icon = R.drawable.ic_settings
    )
}

