package com.testdex.local.utils

import com.testdex.data.model.PokemonBasicsData
import com.testdex.local.model.PokemonBasicsLocal
import io.realm.kotlin.ext.toRealmList

fun List<PokemonBasicsData>.toPokemonBasicsLocalList() = map { it.toPokemonBasicsLocal() }

fun PokemonBasicsData.toPokemonBasicsLocal(): PokemonBasicsLocal {
    val pokemonBasicsLocal = PokemonBasicsLocal()

    pokemonBasicsLocal.pokedexOrder = pokedexOrder
    pokemonBasicsLocal.name = name
    pokemonBasicsLocal.types = types.toRealmList()

    return pokemonBasicsLocal
}

fun List<PokemonBasicsLocal>.toPokemonBasicsDataList() = map { it.toPokemonBasicsData() }

fun PokemonBasicsLocal.toPokemonBasicsData() = PokemonBasicsData(
    pokedexOrder = pokedexOrder,
    name = name,
    types = types
)