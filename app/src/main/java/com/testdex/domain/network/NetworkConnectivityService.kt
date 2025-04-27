package com.testdex.domain.network

import kotlinx.coroutines.flow.Flow

interface NetworkConnectivityService {
    val isConnected: Flow<Boolean>
}