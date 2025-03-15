package com.testdex.local.model

import com.testdex.ui.utils.empty
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class PokemonBasicsLocal: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId()
    var pokedexOrder: Int = 0
    var name: String = String.empty
    var types: RealmList<String> = realmListOf()
}