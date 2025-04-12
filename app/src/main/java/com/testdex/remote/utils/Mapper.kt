package com.testdex.remote.utils

import com.testdex.data.model.AbilityData
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonBasicsData
import com.testdex.data.model.PokemonData
import com.testdex.data.model.SpriteData
import com.testdex.data.model.StatData
import com.testdex.remote.model.AbilityRemote
import com.testdex.remote.model.MoveInfoRemote
import com.testdex.remote.model.MoveRemote
import com.testdex.remote.model.PokemonBasicsRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.model.RemoteErrorType
import com.testdex.remote.model.SpriteRemote
import com.testdex.remote.model.StatRemote
import com.testdex.utils.empty

fun StatRemote.toStatData() = StatData(
    name = statInfo.name,
    base = base
)

fun List<StatRemote>.toStatsData() = map { it.toStatData() }

// TODO Retrieve description of the ability
fun AbilityRemote.toAbilityData() = AbilityData(
    name = abilityInfo.name,
    description = String.empty,
    isHidden = isHidden
)

fun List<AbilityRemote>.toAbilitiesData() = map { it.toAbilityData() }

fun MoveRemote.toMoveData(moveInfo: MoveInfoRemote) = MoveData(
    name = moveUrl.name,
    power = moveInfo.power,
    accuracy = moveInfo.accuracy,
    pp = moveInfo.pp,
    description = moveInfo.effectEntries.firstOrNull()?.effect ?: String.empty,
    type = moveInfo.type.name
)

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
    moves: List<MoveData>
) = PokemonData(
    pokedexOrder = pokedexOrder,
    name = name,
    height = height / Constants.POKEMON_MEASUREMENT_DIVISOR,
    weight = weight / Constants.POKEMON_MEASUREMENT_DIVISOR,
    types = types.map { it.typeInfo.name },
    stats = stats.toStatsData(),
    abilities = abilities.toAbilitiesData(),
    moves = moves,
    sprite = sprite.toSpriteData()
)

fun PokemonBasicsRemote.toPokemonBasicsData() = PokemonBasicsData(
    pokedexOrder = pokedexOrder,
    name = name,
    types = types.map { it.typeInfo.name }
)

fun RemoteErrorType.toDataErrorType(): DataErrorType = when(this) {
    is RemoteErrorType.NotFoundRemoteError -> DataErrorType.NotFoundDataError
    is RemoteErrorType.ServerRemoteError -> DataErrorType.ServerDataError
    is RemoteErrorType.ExceptionRemoteError -> DataErrorType.NotFoundDataError
}