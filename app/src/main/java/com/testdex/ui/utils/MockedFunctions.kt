package com.testdex.ui.utils

import androidx.compose.ui.graphics.Color
import com.testdex.R
import com.testdex.ui.model.AbilityUIModel
import com.testdex.ui.model.MoveUIModel
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.model.SpriteUIModel
import com.testdex.ui.model.StatUIModel
import com.testdex.ui.model.TypeUIModel
import com.testdex.ui.theme.Gray

private val fireType = TypeUIModel(
    name = "Fire",
    color = Color.Red,
    imageResId = R.mipmap.ic_fire_type
)

private val darkType = TypeUIModel(
    name = "Dark",
    color = Gray,
    imageResId = R.mipmap.ic_dark_type
)

private val megaPunchMove = MoveUIModel(
    name = "mega-punch",
    power = 80,
    accuracy = 85,
    pp = 20,
    description = "Inflicts regular damage with no additional effect.",
    type = TypeUIModel(
        name = "Normal",
        imageResId = R.mipmap.ic_normal_type,
        color = Gray
    )
)

private val hpStat = StatUIModel(
    name = "HP",
    base = 39
)

private val defenseStat = StatUIModel(
    name = "Defense",
    base = 200
)

private val blazeAbility = AbilityUIModel(
    name = "Blaze",
    description = "Description",
    isHidden = false
)


fun mockedPokemonList(): List<PokemonUIModel> = listOf(
    PokemonUIModel(
        pokedexOrder = 1,
        name = "Charmander",
        height = 6.0,
        weight = 85.0,
        types = listOf(fireType),
        stats = listOf(
            hpStat,
            hpStat,
            hpStat,
            hpStat,
            hpStat,
            defenseStat,
        ),
        abilities = listOf(blazeAbility),
        moves = listOf(
            megaPunchMove,
            megaPunchMove,
            megaPunchMove,
            megaPunchMove,
            megaPunchMove,
            megaPunchMove,
        ),
        sprite = SpriteUIModel(
            officialArtworkURI = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
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
            fireType,
            darkType
        ),
        stats = listOf(
            hpStat,
            hpStat,
            hpStat,
            hpStat,
            hpStat,
            hpStat
        ),
        abilities = listOf(blazeAbility),
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