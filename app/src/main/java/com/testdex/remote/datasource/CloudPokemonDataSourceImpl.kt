package com.testdex.remote.datasource

import arrow.core.Either
import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonBasicsData
import com.testdex.remote.model.AllPokemonInfoRemote
import com.testdex.remote.model.PokemonBasicsRemote
import com.testdex.remote.utils.Constants
import com.testdex.remote.utils.safeApiCall
import com.testdex.remote.utils.toPokemonBasicsData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import kotlinx.coroutines.coroutineScope

class CloudPokemonDataSourceImpl(
    private val client: HttpClient
) : CloudPokemonDataSource {

    override suspend fun retrieveAllPokemonUrls(): Either<DataErrorType, List<String>> {
        return safeApiCall(
            client = client,
            url = Constants.ALL_POKEMON_URL
        ) { response ->
            val allPokemonInfo: AllPokemonInfoRemote = response.body()
            allPokemonInfo.results.map { it.url }
        }
    }

    override suspend fun retrievePokemonBasics(url: String): Either<DataErrorType, PokemonBasicsData> = coroutineScope {
        safeApiCall(
            client = client,
            url = url
        ) { response ->
            val pokemonBasicsRemote: PokemonBasicsRemote = response.body()
            pokemonBasicsRemote.toPokemonBasicsData()
        }
    }
}