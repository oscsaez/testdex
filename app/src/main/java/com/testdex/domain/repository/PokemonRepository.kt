package com.testdex.domain.repository

import com.testdex.domain.model.Pokemon

interface PokemonRepository {

    fun retrievePokemonList(limit: Int): List<Pokemon>
}