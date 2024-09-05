package com.testdex.di

import com.testdex.domain.repository.PokemonRepository
import com.testdex.domain.use_case.RetrievePokemonListUseCase
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
    fun providesRetrievePokemonListUseCase(
        pokemonRepository: PokemonRepository
    ): RetrievePokemonListUseCase {
        return RetrievePokemonListUseCase(pokemonRepository)
    }
}