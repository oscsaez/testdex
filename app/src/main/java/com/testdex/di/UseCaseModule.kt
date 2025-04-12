package com.testdex.di

import com.testdex.domain.repository.PokemonRepository
import com.testdex.domain.use_case.RetrieveAllPokemonBasicsUseCase
import com.testdex.domain.use_case.RetrievePokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesRetrieveAllPokemonBasicsListUseCase(
        pokemonRepository: PokemonRepository
    ): RetrieveAllPokemonBasicsUseCase {
        return RetrieveAllPokemonBasicsUseCase(pokemonRepository)
    }

    @Provides
    @Singleton
    fun provideRetrievePokemonUseCase(
        pokemonRepository: PokemonRepository
    ): RetrievePokemon = RetrievePokemon(pokemonRepository)
}