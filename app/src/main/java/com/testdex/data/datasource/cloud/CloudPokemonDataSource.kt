package com.testdex.data.datasource.cloud

import arrow.core.Either
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonBasicsData
import com.testdex.data.model.PokemonData

interface CloudPokemonDataSource {

    suspend fun retrieveAllPokemonUrls(): Either<DataErrorType, List<String>>
    suspend fun retrievePokemonBasics(url: String): Either<DataErrorType, PokemonBasicsData>
    suspend fun retrievePokemonByName(name: String): Either<DataErrorType, PokemonData>
}