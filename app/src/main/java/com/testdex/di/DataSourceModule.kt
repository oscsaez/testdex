package com.testdex.di

import com.testdex.data.datasource.cloud.CloudPokemonDataSource
import com.testdex.data.datasource.local.LocalPokemonDataSource
import com.testdex.local.database.RealmDatabase
import com.testdex.local.datasource.LocalPokemonDataSourceImpl
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

    // Cloud

    @Provides
    @Singleton
    fun provideCloudPokemonDataSource(
        client: HttpClient
    ): CloudPokemonDataSource = CloudPokemonDataSourceImpl(client)

    // Local

    @Provides
    @Singleton
    fun provideLocalPokemonDataSource(
        realmDatabase: RealmDatabase
    ): LocalPokemonDataSource = LocalPokemonDataSourceImpl(realmDatabase)
}