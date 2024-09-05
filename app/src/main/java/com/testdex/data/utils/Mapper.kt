package com.testdex.data.utils

import com.testdex.data.model.AbilityData
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonData
import com.testdex.data.model.SpriteData
import com.testdex.data.model.StatData
import com.testdex.domain.model.Ability
import com.testdex.domain.model.Move
import com.testdex.domain.model.Pokemon
import com.testdex.domain.model.Sprite
import com.testdex.domain.model.Stat

fun StatData.toStat() = Stat(
    name = name,
    base = base
)

fun List<StatData>.toStats() = map { it.toStat() }

fun AbilityData.toAbility() = Ability(
    name = name,
    description = description,
    isHidden = isHidden
)

fun List<AbilityData>.toAbilities() = map { it.toAbility() }

fun MoveData.toMove() = Move(
    name = name,
    power = power,
    accuracy = accuracy,
    pp = pp,
    description = description,
    type = type
)

fun List<MoveData>.toMoves() = map { it.toMove() }

fun SpriteData.toSprite() = Sprite(
    officialArtworkURI = officialArtworkURI,
    backMaleURI = backMaleURI,
    backFemaleURI = backFemaleURI,
    backShinyMaleURI = backShinyMaleURI,
    backShinyFemaleURI = backShinyFemaleURI,
    frontMaleURI = frontMaleURI,
    frontFemaleURI = frontFemaleURI,
    frontShinyMaleURI = frontShinyMaleURI,
    frontShinyFemaleURI = frontShinyFemaleURI
)

fun PokemonData.toPokemon() = Pokemon(
    pokedexOrder = pokedexOrder,
    name = name,
    height = height,
    weight = weight,
    types = types,
    stats = stats.toStats(),
    abilities = abilities.toAbilities(),
    moves = moves.toMoves(),
    sprite = sprite.toSprite()
)