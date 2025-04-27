package com.testdex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.domain.network.NetworkConnectivityService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkConnectivityService: NetworkConnectivityService
): ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        observeNetworkConnection()
    }

    private fun observeNetworkConnection() {
        viewModelScope.launch {
            networkConnectivityService.isConnected.collect { isConnected ->
                _state.update { currentState ->
                    currentState.copy(isConnected = isConnected)
                }
            }
        }
    }
}