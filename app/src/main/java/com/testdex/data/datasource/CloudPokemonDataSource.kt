package com.testdex.data.datasource

import arrow.core.Either
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonData

interface CloudPokemonDataSource {

    fun retrievePokemonList(minimum: Int): Either<DataErrorType, List<PokemonData>>
}