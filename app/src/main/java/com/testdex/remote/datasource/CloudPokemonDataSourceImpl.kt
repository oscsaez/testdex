package com.testdex.remote.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonData
import com.testdex.remote.model.AbilityEffectRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.model.RemoteErrorType
import com.testdex.remote.utils.Constants
import com.testdex.remote.utils.toAbilitiesData
import com.testdex.remote.utils.toDataErrorType
import com.testdex.remote.utils.toPokemonData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class CloudPokemonDataSourceImpl(
    private val client: HttpClient
) : CloudPokemonDataSource {

    override suspend fun retrievePokemonList(pokedexOrder: Int): Either<DataErrorType, PokemonData> = coroutineScope {
        try {
            val response: HttpResponse = client.get("${Constants.POKEMON_URL}$pokedexOrder")

            when (response.status.value) {
                in 200..299 -> {
                    val pokemon: PokemonRemote = response.body()

                    val abilityEffectDeferredList = pokemon.abilities.map { ability ->
                        async {
                            retrieveAbility(ability.abilityInfo.url)
                        }
                    }
                    /*val moveInfoDeferredList = pokemon.moves.map { move ->
                        async {
                            retrieveMove(move.moveUrl.url)
                        }
                    }*/

                    val abilityEffects = abilityEffectDeferredList.awaitAll().mapNotNull { result ->
                        result.fold(
                            ifLeft = { null },
                            ifRight = { it }
                        )
                    }
                    /*val moveInfoList = moveInfoDeferredList.awaitAll().mapNotNull { result ->
                        result.fold(
                            ifLeft = { null },
                            ifRight = { it }
                        )
                    }*/

                    pokemon.toPokemonData(
                        pokedexOrder = pokedexOrder,
                        abilities = pokemon.abilities.toAbilitiesData(abilityEffects),
                        moves = emptyList() /*pokemon.moves.toMovesData(moveInfoList)*/
                    ).right()
                }
                in 400..499 -> {
                    RemoteErrorType.NotFoundError.toDataErrorType().left()
                }
                else -> {
                    RemoteErrorType.ServerError.toDataErrorType().left()
                }
            }
        } catch (e: Exception) {
            RemoteErrorType.ExceptionError.toDataErrorType().left()
        }
    }

    private suspend fun retrieveAbility(url: String): Either<RemoteErrorType, AbilityEffectRemote> {
        return try {
            val response: HttpResponse = client.get(url)

            when (response.status.value) {
                in 200..299 -> {
                    val abilityEffect: AbilityEffectRemote = response.body()
                    abilityEffect.right()
                }
                in 400..499 -> {
                    RemoteErrorType.NotFoundError.left()
                }
                else -> {
                    RemoteErrorType.ServerError.left()
                }
            }
        } catch (e: Exception) {
            RemoteErrorType.ExceptionError.left()
        }
    }

    // TODO This is commented at the moment because it takes a long time to obtain this information
    /*private suspend fun retrieveMove(url: String): Either<RemoteErrorType, MoveInfoRemote> {
        return try {
            val response: HttpResponse = client.get(url)

            when (response.status.value) {
                in 200..299 -> {
                    val moveInfo: MoveInfoRemote = response.body()
                    moveInfo.right()
                }
                in 400..499 -> {
                    RemoteErrorType.NotFoundError.left()
                }
                else -> {
                    RemoteErrorType.ServerError.left()
                }
            }
        } catch (e: Exception) {
            RemoteErrorType.ExceptionError.left()
        }
    }*/
}