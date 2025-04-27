package com.testdex.di

import android.content.Context
import com.testdex.data.network.NetworkConnectivityServiceImpl
import com.testdex.domain.network.NetworkConnectivityService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkConnectivityService(
        @ApplicationContext context: Context
    ): NetworkConnectivityService = NetworkConnectivityServiceImpl(context)
}