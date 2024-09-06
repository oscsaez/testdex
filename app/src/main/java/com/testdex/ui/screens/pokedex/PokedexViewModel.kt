package com.testdex.ui.screens.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.domain.use_case.RetrievePokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val retrievePokemonListUseCase: RetrievePokemonListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PokedexState())
    val state: StateFlow<PokedexState> = _state.asStateFlow()

    private val _limit = 30

    fun onEvent(event: PokedexEvent) = when(event) {
        is PokedexEvent.RetrievePokemonList -> retrievePokemonList()
        is PokedexEvent.SearchPokemonByName -> {}
    }

    private fun retrievePokemonList() {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    loading = false
                )
            }

            retrievePokemonListUseCase(_limit).fold(
                ifLeft = {
                    // TODO Error case
                },
                ifRight = {
                    // TODO Right case
                }
            )
        }
    }
}