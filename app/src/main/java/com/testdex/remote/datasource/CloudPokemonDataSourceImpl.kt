package com.testdex.remote.datasource

import arrow.core.Either
import com.testdex.data.datasource.cloud.CloudPokemonDataSource
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.MoveData
import com.testdex.data.model.PokemonBasicsData
import com.testdex.data.model.PokemonData
import com.testdex.remote.model.AllPokemonInfoRemote
import com.testdex.remote.model.MoveInfoRemote
import com.testdex.remote.model.MoveRemote
import com.testdex.remote.model.PokemonBasicsRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.utils.Constants
import com.testdex.remote.utils.safeApiCall
import com.testdex.remote.utils.toMoveData
import com.testdex.remote.utils.toPokemonBasicsData
import com.testdex.remote.utils.toPokemonData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
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

    override suspend fun retrievePokemonByName(name: String): Either<DataErrorType, PokemonData> = coroutineScope {
        safeApiCall(
            client = client,
            url = "${Constants.POKEMON_URL}$name"
        ) { response ->
            val pokemon: PokemonRemote = response.body()

            val movesRemote: List<MoveData> = pokemon.moves.map { move ->
                async {
                    retrieveMoveDetails(move)
                }
            }.awaitAll()

            pokemon.toPokemonData(movesRemote)
        }
    }

    private suspend fun retrieveMoveDetails(move: MoveRemote): MoveData = coroutineScope {
        val moveInfo: MoveInfoRemote = client.get(move.moveUrl.url).body()
        move.toMoveData(moveInfo)
    }
}