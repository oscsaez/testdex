package com.testdex.remote.utils

import com.testdex.data.model.AbilityData
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonBasicsData
import com.testdex.data.model.PokemonData
import com.testdex.data.model.SpriteData
import com.testdex.data.model.StatData
import com.testdex.remote.model.AbilityEffectRemote
import com.testdex.remote.model.AbilityRemote
import com.testdex.remote.model.MoveInfoRemote
import com.testdex.remote.model.MoveRemote
import com.testdex.remote.model.PokemonBasicsRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.model.RemoteErrorType
import com.testdex.remote.model.SpriteRemote
import com.testdex.remote.model.StatRemote
import java.util.Locale

fun StatRemote.toStatData() = StatData(
    name = statInfo.name,
    base = base
)

fun List<StatRemote>.toStatsData() = map { it.toStatData() }

fun AbilityRemote.toAbilityData(abilityEffects: AbilityEffectRemote) = AbilityData(
    name = abilityInfo.name.capitalize(Locale.ROOT),
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
    description = moveInfo.effectEntries.firstOrNull()?.effect ?: "", // TODO Remove this empty string
    type = moveInfo.type.name
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

fun PokemonRemote.toPokemonData(
    abilities: List<AbilityData>,
    moves: List<MoveData>
) = PokemonData(
    pokedexOrder = pokedexOrder,
    name = name.capitalize(Locale.ROOT),
    height = height,
    weight = weight,
    types = types.map { it.typeInfo.name },
    stats = stats.toStatsData(),
    abilities = abilities,
    moves = moves,
    sprite = sprite.toSpriteData()
)

fun PokemonBasicsRemote.toPokemonBasicsData() = PokemonBasicsData(
    pokedexOrder = pokedexOrder,
    name = name.capitalize(Locale.ROOT),
    types = types.map { it.typeInfo.name }
)

fun RemoteErrorType.toDataErrorType(): DataErrorType = when(this) {
    is RemoteErrorType.NotFoundRemoteError -> DataErrorType.NotFoundDataError
    is RemoteErrorType.ServerRemoteError -> DataErrorType.ServerDataError
    is RemoteErrorType.ExceptionRemoteError -> DataErrorType.NotFoundDataError
}