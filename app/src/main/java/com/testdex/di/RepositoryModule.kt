package com.testdex.di

import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.data.repository.PokemonRepositoryImpl
import com.testdex.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesPokemonRepository(
        cloudPokemonDataSource: CloudPokemonDataSource
    ): PokemonRepository = PokemonRepositoryImpl(cloudPokemonDataSource)
}