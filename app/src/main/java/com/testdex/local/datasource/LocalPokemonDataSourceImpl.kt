package com.testdex.local.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.testdex.data.datasource.local.LocalPokemonDataSource
import com.testdex.data.model.DataErrorType
import com.testdex.data.model.PokemonBasicsData
import com.testdex.local.database.RealmDatabase
import com.testdex.local.model.PokemonBasicsLocal
import com.testdex.local.utils.toPokemonBasicsDataList
import com.testdex.local.utils.toPokemonBasicsLocalList
import io.realm.kotlin.Realm
import io.realm.kotlin.exceptions.RealmException

class LocalPokemonDataSourceImpl(
    realmDatabase: RealmDatabase
) : LocalPokemonDataSource {

    private val realm: Realm = realmDatabase.realm

    override suspend fun storeAllPokemonBasics(pokemonList: List<PokemonBasicsData>): Either<DataErrorType, Unit> {
        return try {
            val pokemonLocalList: List<PokemonBasicsLocal> = pokemonList.toPokemonBasicsLocalList()

            realm.write {
                pokemonLocalList.forEach { pokemon ->
                    copyToRealm(pokemon)
                }
            }

            Unit.right()
        } catch (e: RealmException) {
            DataErrorType.WriteDataError.left()
        }
    }

    override suspend fun getAllPokemonBasics(): Either<DataErrorType, List<PokemonBasicsData>> {
        return try {
            val pokemonList: List<PokemonBasicsLocal> = realm.query(PokemonBasicsLocal::class).find()
            pokemonList.toPokemonBasicsDataList().right()
        } catch (e: RealmException) {
            DataErrorType.ReadDataError.left()
        }
    }

}