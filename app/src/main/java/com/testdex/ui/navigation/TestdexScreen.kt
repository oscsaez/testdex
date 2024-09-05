package com.testdex.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.testdex.R

sealed class TestdexScreen(
    @StringRes val resIdName: Int? = null,
    @DrawableRes val resIdIcon: Int? = null,
    val route: String
) {
    object TestdexPokedexScreen : TestdexScreen(
        resIdName = R.string.pokedex_screen_title,
        resIdIcon = R.drawable.ic_pokeball,
        route = "pokedex"
    )

    object TestdexTableTypesScreen : TestdexScreen(
        resIdName = R.string.types_table_screen_title,
        resIdIcon = R.drawable.ic_table,
        route = "table_types"
    )

    object TestdexFavoritesScreen : TestdexScreen(
        resIdName = R.string.favorites_screen_title,
        resIdIcon = R.drawable.ic_star,
        route = "favorites"
    )

    object TestdexSettingsScreen : TestdexScreen(
        resIdName = R.string.settings_screen_title,
        resIdIcon = R.drawable.ic_settings,
        route = "settings"
    )

    object TestdexPokemonScreen : TestdexScreen(
        route = "pokemon/{pokedexOrder}"
    ) {
        fun createRoute(pokedexOrder: Int) = "pokemon/$pokedexOrder"
    }
}

