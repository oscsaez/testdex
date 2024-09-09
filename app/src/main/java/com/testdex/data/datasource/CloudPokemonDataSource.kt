package com.testdex.data.datasource

import arrow.core.Either
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonData

interface CloudPokemonDataSource {

    suspend fun retrievePokemonList(pokedexOrder: Int): Either<DataErrorType, PokemonData>
}