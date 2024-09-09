package com.testdex.remote.datasource

import android.util.Log
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonData
import com.testdex.remote.model.AbilityEffectRemote
import com.testdex.remote.model.MoveInfoRemote
import com.testdex.remote.model.PokemonRemote
import com.testdex.remote.model.RemoteErrorType
import com.testdex.remote.utils.Constants
import com.testdex.remote.utils.toDataErrorType
import com.testdex.remote.utils.toPokemonData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CloudPokemonDataSourceImpl(
    private val client: HttpClient
) : CloudPokemonDataSource {

    override suspend fun retrievePokemonList(pokedexOrder: Int): Either<DataErrorType, PokemonData> {
        return try {
            val response: HttpResponse = client.get("${Constants.POKEMON_URL}$pokedexOrder")
            Log.i("AQUI", response.status.value.toString())

            when (response.status.value) {
                in 200..299 -> {
                    val pokemon: PokemonRemote = response.body()
                    val abilityEffectList: MutableList<AbilityEffectRemote> = mutableListOf()
                    val moveInfoList: MutableList<MoveInfoRemote> = mutableListOf()
                    val test: String = response.body()
                    Log.i("AQUI", test)


                    Log.i("AQUI", pokemon.toPokemonData(
                        abilities = emptyList(),
                        moves = emptyList()
                    ).toString())
                    pokemon.toPokemonData(
                        abilities = emptyList(),
                        moves = emptyList()
                    ).right()
                }
                in 400..499 -> {
                    Log.i("AQUI", "NotFound")
                    RemoteErrorType.NotFoundError.toDataErrorType().left()
                }
                else -> {
                    Log.i("AQUI", "Server")
                    RemoteErrorType.ServerError.toDataErrorType().left()
                }
            }
        } catch (e: Exception) {
            Log.i("AQUI", e.message.toString(), e)
            RemoteErrorType.ExceptionError.toDataErrorType().left()
        }
    }

    private suspend fun retrieveAbility(url: String): Either<RemoteErrorType, AbilityEffectRemote> {
        return try {
            val response: HttpResponse = client.get(url)

            when (response.status.value) {
                in 200..299 -> {
                    val abilityEffect: AbilityEffectRemote = response.body()
                    Log.i("AQUI", abilityEffect.toString())
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

    private suspend fun retrieveMove(url: String): Either<RemoteErrorType, MoveInfoRemote> {
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
    }
}