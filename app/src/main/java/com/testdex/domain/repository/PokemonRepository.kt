package com.testdex.domain.repository

import arrow.core.Either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon

interface PokemonRepository {

    suspend fun retrievePokemonList(minimum: Int): Either<ErrorType, List<Pokemon>>
}