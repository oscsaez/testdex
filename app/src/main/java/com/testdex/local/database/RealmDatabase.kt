package com.testdex.local.database

import com.testdex.local.model.PokemonBasicsLocal
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Singleton
class RealmDatabase {

    val realm: Realm by lazy {
        Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    PokemonBasicsLocal::class
                )
            )
        )
    }
}