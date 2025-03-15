package com.testdex.domain.repository

import arrow.core.Either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.PokemonBasics
import kotlinx.coroutines.flow.StateFlow

interface PokemonRepository {

    val pokemonProgress: StateFlow<Float>

    // Remote
    suspend fun retrieveAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>>

    // Local
    suspend fun storeAllPokemonBasics(pokemonList: List<PokemonBasics>): Either<ErrorType, Unit>
    suspend fun getAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>>
}