package com.testdex.domain.use_case

import arrow.core.Either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository

class RetrievePokemon(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(name: String): Either<ErrorType, Pokemon> {
        return pokemonRepository.retrievePokemonByName(name)
    }
}