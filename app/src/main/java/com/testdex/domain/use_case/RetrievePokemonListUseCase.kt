package com.testdex.domain.use_case

import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository

class RetrievePokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(limit: Int): List<Pokemon> {
        return pokemonRepository.retrievePokemonList(limit)
    }
}