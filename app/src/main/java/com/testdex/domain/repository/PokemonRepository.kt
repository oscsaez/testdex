package com.testdex.domain.repository

import arrow.core.Either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.PokemonBasics

interface PokemonRepository {

    suspend fun retrieveAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>>
}