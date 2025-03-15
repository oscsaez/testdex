package com.testdex.data.datasource

import arrow.core.Either
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonBasicsData

interface CloudPokemonDataSource {

    suspend fun retrieveAllPokemonUrls(): Either<DataErrorType, List<String>>
    suspend fun retrievePokemonBasics(url: String): Either<DataErrorType, PokemonBasicsData>
}