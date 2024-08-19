package com.testdex.ui.utils

import androidx.compose.ui.graphics.Color
import com.testdex.R
import com.testdex.ui.model.AbilityUIModel
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.model.SpriteUIModel
import com.testdex.ui.model.StatUIModel
import com.testdex.ui.model.TypeUIModel
import com.testdex.ui.theme.Gray

fun mockedPokemonList(): List<PokemonUIModel> = listOf(
    PokemonUIModel(
        pokedexOrder = 1,
        name = "Charmander",
        height = 6.0,
        weight = 85.0,
        types = listOf(
            TypeUIModel(
                name = "Fire",
                color = Color.Red,
                imageResId = R.mipmap.ic_bug_type
            )
        ),
        stats = listOf(
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            )
        ),
        abilities = listOf(
            AbilityUIModel(
                name = "Blaze",
                description = "Description",
                isHidden = false
            )
        ),
        moves = emptyList(),
        sprite = SpriteUIModel(
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty
        )
    ),
    PokemonUIModel(
        pokedexOrder = 1,
        name = "Charmander",
        height = 6.0,
        weight = 85.0,
        types = listOf(
            TypeUIModel(
                name = "Fire",
                color = Color.Red,
                imageResId = R.mipmap.ic_bug_type
            ),
            TypeUIModel(
                name = "Dark",
                color = Gray,
                imageResId = R.mipmap.ic_dark_type
            )
        ),
        stats = listOf(
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            ),
            StatUIModel(
                name = "HP",
                base = 39
            )
        ),
        abilities = listOf(
            AbilityUIModel(
                name = "Blaze",
                description = "Description",
                isHidden = false
            )
        ),
        moves = emptyList(),
        sprite = SpriteUIModel(
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty,
            String.empty
        )
    )
)