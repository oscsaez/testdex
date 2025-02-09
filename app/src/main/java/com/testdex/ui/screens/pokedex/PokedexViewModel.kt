package com.testdex.ui.screens.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.domain.use_case.RetrieveAllPokemonBasicsUseCase
import com.testdex.ui.utils.toPokemonBasicsUIModelList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val retrieveAllPokemonBasicsUseCase: RetrieveAllPokemonBasicsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PokedexState())
    val state: StateFlow<PokedexState> = _state.asStateFlow()

    fun onEvent(event: PokedexEvent) = when(event) {
        is PokedexEvent.RetrieveAllPokemonBasicsList -> retrieveAllPokemonBasicsList()
        is PokedexEvent.SearchPokemonByName -> {}
    }

    private fun retrieveAllPokemonBasicsList() {
        viewModelScope.launch {
            retrieveAllPokemonBasicsUseCase.pokemonProgress.collect { progress ->
                _state.update { currentState ->
                    currentState.copy(
                        pokemonProgress = progress
                    )
                }
            }
        }

        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    loading = true
                )
            }

            retrieveAllPokemonBasicsUseCase().fold(
                ifLeft = {
                    // TODO Error case
                },
                ifRight = { newPokemonList ->
                    _state.update { currentState ->
                        currentState.copy(
                            pokemonList = newPokemonList
                                .toPokemonBasicsUIModelList()
                                .sortedBy { it.pokedexOrder },
                            loading = false
                        )
                    }
                }
            )
        }
    }
}