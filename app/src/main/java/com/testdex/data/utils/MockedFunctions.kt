package com.testdex.data.utils

import com.testdex.data.model.AbilityData
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonData
import com.testdex.data.model.SpriteData
import com.testdex.data.model.StatData


private val megaPunchMove = MoveData(
    name = "mega-punch",
    power = 80,
    accuracy = 85,
    pp = 20,
    description = "Inflicts regular damage with no additional effect.",
    type = "normal"
)

private val swordsDanceMove = MoveData(
    name = "swords-dance",
    power = null,
    accuracy = null,
    pp = 20,
    description = "Raises the user's Attack by two stages.",
    type = "normal"
)

private val hpStat = StatData(
    name = "HP",
    base = 39
)

private val defenseStat = StatData(
    name = "Defense",
    base = 200
)

private val blazeAbility = AbilityData(
    name = "Blaze",
    description = "Description",
    isHidden = false
)


fun mockedPokemonList(): List<PokemonData> = listOf(
    PokemonData(
        pokedexOrder = 1,
        name = "Charmander",
        height = 6.0,
        weight = 85.0,
        types = listOf("fire"),
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
            swordsDanceMove
        ),
        sprite = SpriteData(
            officialArtworkURI = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
    ),
    PokemonData(
        pokedexOrder = 1,
        name = "Charmander",
        height = 6.0,
        weight = 85.0,
        types = listOf(
            "fire",
            "dark"
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
        sprite = SpriteData(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
    )
)