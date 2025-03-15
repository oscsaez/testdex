package com.testdex.domain.use_case

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.PokemonBasics
import com.testdex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.StateFlow

class RetrieveAllPokemonBasicsUseCase(
    private val pokemonRepository: PokemonRepository
) {
    val pokemonProgress: StateFlow<Float> = pokemonRepository.pokemonProgress
    suspend operator fun invoke() : Either<ErrorType, List<PokemonBasics>> = either {
        val pokemonFromLocalDb: List<PokemonBasics> = pokemonRepository.getAllPokemonBasics().bind()

        pokemonFromLocalDb.ifEmpty {
            val pokemonBasics: List<PokemonBasics> = pokemonRepository.retrieveAllPokemonBasics().bind()
            pokemonRepository.storeAllPokemonBasics(pokemonBasics).bind()

            pokemonBasics
        }
    }
}