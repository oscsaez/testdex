package com.testdex.data.repository

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.data.datasource.cloud.CloudPokemonDataSource
import com.testdex.data.datasource.local.LocalPokemonDataSource
import com.testdex.data.model.PokemonBasicsData
import com.testdex.data.utils.toErrorType
import com.testdex.data.utils.toPokemon
import com.testdex.data.utils.toPokemonBasicsDataList
import com.testdex.data.utils.toPokemonBasicsList
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.model.PokemonBasics
import com.testdex.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val cloudPokemonDataSource: CloudPokemonDataSource,
    private val localPokemonDataSource: LocalPokemonDataSource
) : PokemonRepository {

    private val _pokemonProgress = MutableStateFlow(0f)
    override val pokemonProgress: StateFlow<Float> = _pokemonProgress.asStateFlow()

    override suspend fun retrieveAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>> = withContext(Dispatchers.IO) {
        either {
            val allPokemonUrls: List<String> = cloudPokemonDataSource.retrieveAllPokemonUrls().bind()
            val totalPokemonCount: Int = allPokemonUrls.size
            var currentPokemonCount = 0

            _pokemonProgress.value = 0f

            allPokemonUrls.map { url ->
                async {
                    val pokemonBasics: PokemonBasicsData = cloudPokemonDataSource.retrievePokemonBasics(url).bind()
                    currentPokemonCount++
                    _pokemonProgress.value = currentPokemonCount.toFloat() / totalPokemonCount.toFloat()
                    pokemonBasics
                }
            }.awaitAll().toPokemonBasicsList()
        }.mapLeft {
            it.toErrorType()
        }
    }

    override suspend fun retrievePokemonByPokedexOrder(pokedexOrder: Int): Either<ErrorType, Pokemon> = withContext(Dispatchers.IO) {
        either {
            cloudPokemonDataSource.retrievePokemonByPokedexOrder(pokedexOrder).bind().toPokemon()
        }.mapLeft {
            it.toErrorType()
        }
    }

    override suspend fun storeAllPokemonBasics(
        pokemonList: List<PokemonBasics>
    ): Either<ErrorType, Unit> = withContext(Dispatchers.IO) {
        localPokemonDataSource.storeAllPokemonBasics(pokemonList.toPokemonBasicsDataList())
            .mapLeft {
                it.toErrorType()
            }
    }

    override suspend fun getAllPokemonBasics(): Either<ErrorType, List<PokemonBasics>> = withContext(Dispatchers.IO) {
        either {
            localPokemonDataSource.getAllPokemonBasics().bind().toPokemonBasicsList()
        }.mapLeft {
            it.toErrorType()
        }
    }
}