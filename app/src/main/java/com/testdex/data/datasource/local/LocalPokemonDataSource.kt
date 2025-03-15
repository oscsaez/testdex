package com.testdex.data.datasource.local

import arrow.core.Either
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonBasicsData

interface LocalPokemonDataSource {

    suspend fun storeAllPokemonBasics(pokemonList: List<PokemonBasicsData>): Either<DataErrorType, Unit>
    suspend fun getAllPokemonBasics(): Either<DataErrorType, List<PokemonBasicsData>>
}