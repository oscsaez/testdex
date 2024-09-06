package com.testdex.domain.use_case

import arrow.core.Either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository

class RetrievePokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(limit: Int): Either<ErrorType, List<Pokemon>> {
        return pokemonRepository.retrievePokemonList(limit)
    }
}