package com.testdex.di

import com.testdex.data.datasource.cloud.CloudPokemonDataSource
import com.testdex.data.datasource.local.LocalPokemonDataSource
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
        cloudPokemonDataSource: CloudPokemonDataSource,
        localPokemonDataSource: LocalPokemonDataSource
    ): PokemonRepository = PokemonRepositoryImpl(cloudPokemonDataSource, localPokemonDataSource)
}