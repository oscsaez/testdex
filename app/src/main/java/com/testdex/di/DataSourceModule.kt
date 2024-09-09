package com.testdex.di

import com.testdex.data.datasource.CloudPokemonDataSource
import com.testdex.remote.datasource.CloudPokemonDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCloudPokemonDataSource(
        client: HttpClient
    ): CloudPokemonDataSource = CloudPokemonDataSourceImpl(client)
}