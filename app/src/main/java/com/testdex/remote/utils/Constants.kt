package com.testdex.remote.utils

object Constants {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    const val POKEMON_URL = "${BASE_URL}pokemon/"
    const val ALL_POKEMON_URL = "${POKEMON_URL}?limit=${Int.MAX_VALUE}"
}