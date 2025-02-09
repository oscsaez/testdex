package com.testdex.domain.use_case

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.PokemonBasics
import com.testdex.domain.repository.PokemonRepository

class RetrieveAllPokemonBasicsUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke() : Either<ErrorType, List<PokemonBasics>> = either {
        pokemonRepository.retrieveAllPokemonBasics().bind()
    }
}