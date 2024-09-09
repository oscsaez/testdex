package com.testdex.remote.utils

import com.testdex.data.model.AbilityData
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonData
import com.testdex.data.model.SpriteData
import com.testdex.data.model.StatData
import com.testdex.remote.model.AbilityEffectRemote
import com.testdex.remote.model.AbilityRemote
import com.testdex.remote.model.MoveInfoRemote
import com.testdex.remote.model.MoveRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.model.RemoteErrorType
import com.testdex.remote.model.SpriteRemote
import com.testdex.remote.model.StatRemote

fun StatRemote.toStatData() = StatData(
    name = statInfo.name,
    base = base
)

fun List<StatRemote>.toStatsData() = map { it.toStatData() }

fun AbilityRemote.toAbilityData(abilityEffects: AbilityEffectRemote) = AbilityData(
    name = abilityInfo.name,
    description = abilityEffects.effectEntries.first().effect,
    isHidden = isHidden
)

fun List<AbilityRemote>.toAbilitiesData(abilityEffectsList: List<AbilityEffectRemote>) = mapIndexed { index, abilityRemote ->
    abilityRemote.toAbilityData(abilityEffectsList[index])
}

fun MoveRemote.toMoveData(moveInfo: MoveInfoRemote) = MoveData(
    name = moveUrl.name,
    power = moveInfo.power,
    accuracy = moveInfo.accuracy,
    pp = moveInfo.pp,
    description = moveInfo.effectEntries.first().effect,
    type = moveInfo.type
)

fun List<MoveRemote>.toMovesData(moveInfoList: List<MoveInfoRemote>) = mapIndexed { index, moveRemote ->
    moveRemote.toMoveData(moveInfoList[index])
}

fun SpriteRemote.toSpriteData() = SpriteData(
    officialArtworkURI = otherSprites.officialArtworkSpriteRemote.frontMaleURI,
    backMaleURI = backMaleURI,
    backFemaleURI = backFemaleURI,
    backShinyMaleURI = backShinyMaleURI,
    backShinyFemaleURI = backShinyFemaleURI,
    frontMaleURI = frontMaleURI,
    frontFemaleURI = frontFemaleURI,
    frontShinyMaleURI = frontShinyMaleURI,
    frontShinyFemaleURI = frontShinyFemaleURI
)

fun PokemonRemote.toPokemonData(abilities: List<AbilityData>, moves: List<MoveData>) = PokemonData(
    pokedexOrder = pokedexOrder,
    name = name,
    height = height,
    weight = weight,
    types = types.map { it.typeInfo.name },
    stats = stats.toStatsData(),
    abilities = abilities,
    moves = moves,
    sprite = sprite.toSpriteData()
)

// TODO Temporally
fun RemoteErrorType.toDataErrorType() = DataErrorType.NetworkDataError