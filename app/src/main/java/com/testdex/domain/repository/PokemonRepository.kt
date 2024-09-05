package com.testdex.domain.repository

import com.testdex.domain.model.Pokemon

interface PokemonRepository {

    suspend fun retrievePokemonList(limit: Int): List<Pokemon>
}