package com.testdex.data.repository

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.utils.toErrorType
import com.testdex.data.utils.toPokemon
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val cloudPokemonDataSource: CloudPokemonDataSource
) : PokemonRepository {

    override suspend fun retrievePokemonList(pokedexOrder: Int): Either<ErrorType, Pokemon> = withContext(Dispatchers.IO) {
        either {
            cloudPokemonDataSource.retrievePokemonList(pokedexOrder).bind().toPokemon()
        }.mapLeft {
            it.toErrorType()
        }
    }
}