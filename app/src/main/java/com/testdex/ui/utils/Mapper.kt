package com.testdex.ui.utils

import com.testdex.R
import com.testdex.domain.model.Ability
import com.testdex.domain.model.Move
import com.testdex.domain.model.Pokemon
import com.testdex.domain.model.Sprite
import com.testdex.domain.model.Stat
import com.testdex.ui.model.AbilityUIModel
import com.testdex.ui.model.MoveUIModel
import com.testdex.ui.model.PokemonUIModel
import com.testdex.ui.model.SpriteUIModel
import com.testdex.ui.model.StatUIModel
import com.testdex.ui.model.TypeUIModel
import com.testdex.ui.theme.BugTypeColor
import com.testdex.ui.theme.DarkTypeColor
import com.testdex.ui.theme.DragonTypeColor
import com.testdex.ui.theme.ElectricTypeColor
import com.testdex.ui.theme.FairyTypeColor
import com.testdex.ui.theme.FightingTypeColor
import com.testdex.ui.theme.FireTypeColor
import com.testdex.ui.theme.FlyingTypeColor
import com.testdex.ui.theme.GhostTypeColor
import com.testdex.ui.theme.GrassTypeColor
import com.testdex.ui.theme.GroundTypeColor
import com.testdex.ui.theme.IceTypeColor
import com.testdex.ui.theme.NormalTypeColor
import com.testdex.ui.theme.PoisonTypeColor
import com.testdex.ui.theme.PsychicTypeColor
import com.testdex.ui.theme.RockTypeColor
import com.testdex.ui.theme.SteelTypeColor
import com.testdex.ui.theme.WaterTypeColor

// TODO Deal with domain errors

fun Ability.toAbilityUIModel() = AbilityUIModel(
    name = name,
    description = description,
    isHidden = isHidden
)

fun List<Ability>.toAbilitiesUIModel() = map { it.toAbilityUIModel() }

fun String.toTypeUIModel(): TypeUIModel = when(this) {
    "bug" -> TypeUIModel(R.string.bug_type_text, R.mipmap.ic_bug_type, BugTypeColor)
    "dark" -> TypeUIModel(R.string.dark_type_text, R.mipmap.ic_dark_type, DarkTypeColor)
    "dragon" -> TypeUIModel(R.string.dragon_type_text, R.mipmap.ic_dragon_type, DragonTypeColor)
    "electric" -> TypeUIModel(R.string.electric_type_text, R.mipmap.ic_electric_type, ElectricTypeColor)
    "fairy" -> TypeUIModel(R.string.fairy_type_text, R.mipmap.ic_fairy_type, FairyTypeColor)
    "fighting" -> TypeUIModel(R.string.fighting_type_text, R.mipmap.ic_fight_type, FightingTypeColor)
    "fire" -> TypeUIModel(R.string.fire_type_text, R.mipmap.ic_fire_type, FireTypeColor)
    "flying" -> TypeUIModel(R.string.flying_type_text, R.mipmap.ic_flying_type, FlyingTypeColor)
    "ghost" -> TypeUIModel(R.string.ghost_type_text, R.mipmap.ic_ghost_type, GhostTypeColor)
    "grass" -> TypeUIModel(R.string.grass_type_text, R.mipmap.ic_grass_type, GrassTypeColor)
    "ground" -> TypeUIModel(R.string.ground_type_text, R.mipmap.ic_ground_type, GroundTypeColor)
    "ice" -> TypeUIModel(R.string.ice_type_text, R.mipmap.ic_ice_type, IceTypeColor)
    "normal" -> TypeUIModel(R.string.normal_type_text, R.mipmap.ic_normal_type, NormalTypeColor)
    "psychic" -> TypeUIModel(R.string.psychic_type_text, R.mipmap.ic_psychic_type, PsychicTypeColor)
    "rock" -> TypeUIModel(R.string.rock_type_text, R.mipmap.ic_rock_type, RockTypeColor)
    "steel" -> TypeUIModel(R.string.steel_type_text, R.mipmap.ic_steel_type, SteelTypeColor)
    "water" -> TypeUIModel(R.string.water_type_text, R.mipmap.ic_water_type, WaterTypeColor)
    "poison" -> TypeUIModel(R.string.poison_type_text, R.mipmap.ic_poison_type, PoisonTypeColor)
    else -> TypeUIModel(R.string.bug_type_text, R.mipmap.ic_bug_type, BugTypeColor)
}

fun List<String>.toTypesUIModel(): List<TypeUIModel> = map { it.toTypeUIModel() }

fun Move.toMoveUIModel() = MoveUIModel(
    name = name,
    power = power,
    accuracy = accuracy,
    pp = pp,
    description = description,
    type = type.toTypeUIModel()
)

fun List<Move>.toMovesUIModel() = map { it.toMoveUIModel() }

fun Sprite.toSpriteUIModel() = SpriteUIModel(
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

fun Stat.toStatUIModel() = StatUIModel(
    name = name,
    base = base
)

fun List<Stat>.toStatsUIModel() = map { it.toStatUIModel() }

fun Pokemon.toPokemonUIModel() = PokemonUIModel(
    pokedexOrder = pokedexOrder,
    name = name,
    height = height,
    weight = weight,
    types = types.toTypesUIModel(),
    stats = stats.toStatsUIModel(),
    abilities = abilities.toAbilitiesUIModel(),
    moves = moves.toMovesUIModel(),
    sprite = sprite.toSpriteUIModel()
)

fun List<Pokemon>.toPokemonUIModelList() = map { it.toPokemonUIModel() }