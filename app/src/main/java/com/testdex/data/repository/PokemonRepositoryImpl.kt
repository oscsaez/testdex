package com.testdex.data.repository

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.data.utils.mockedPokemonList
import com.testdex.data.utils.toPokemon
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    // TODO private val cloudPokemonDataSource: CloudPokemonDataSource
) : PokemonRepository {

    override suspend fun retrievePokemonList(limit: Int): Either<ErrorType, List<Pokemon>> {
        return either {
            mockedPokemonList().toPokemon()
        }
    }
}