package com.testdex.data.repository

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.utils.toErrorType
import com.testdex.data.utils.toPokemonBasicsList
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.PokemonBasics
import com.testdex.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val cloudPokemonDataSource: CloudPokemonDataSource
) : PokemonRepository {

    override suspend fun retrieveAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>> = withContext(Dispatchers.IO) {
        either {
            val allPokemonUrls: List<String> = cloudPokemonDataSource.retrieveAllPokemonUrls().bind()
            allPokemonUrls.map { url ->
                async {
                    cloudPokemonDataSource.retrievePokemonBasics(url).bind()
                }
            }.awaitAll().toPokemonBasicsList()
        }.mapLeft {
            it.toErrorType()
        }
    }
}