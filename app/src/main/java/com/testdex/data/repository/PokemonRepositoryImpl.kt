package com.testdex.data.repository

import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.utils.mockedPokemonList
import com.testdex.data.utils.toPokemon
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val cloudPokemonDataSource: CloudPokemonDataSource
) : PokemonRepository {

    override fun retrievePokemonList(): List<Pokemon> {
        return mockedPokemonList().toPokemon()
    }
}