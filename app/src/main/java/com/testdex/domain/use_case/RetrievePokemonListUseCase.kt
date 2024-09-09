package com.testdex.domain.use_case

import arrow.core.Either
import arrow.core.raise.either
import com.testdex.domain.model.ErrorType
import com.testdex.domain.model.Pokemon
import com.testdex.domain.repository.PokemonRepository
import com.testdex.domain.utils.Constants

class RetrievePokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(minimum: Int): Either<ErrorType, List<Pokemon>> = either {
        val pokemonList: MutableList<Pokemon> = mutableListOf()

        for(i in 1..Constants.NUMBER_OF_POKEMON_PER_PAGE) {
            val pokemon = pokemonRepository.retrievePokemonList(minimum + i).bind()
            pokemonList.add(pokemon)
        }
        pokemonList
    }
}