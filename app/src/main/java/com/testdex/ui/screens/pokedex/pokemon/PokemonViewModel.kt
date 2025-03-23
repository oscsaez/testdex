package com.testdex.ui.screens.pokedex.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.domain.use_case.RetrievePokemon
import com.testdex.ui.utils.toPokemonUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val retrievePokemonUseCase: RetrievePokemon
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val state: StateFlow<PokemonState> = _state.asStateFlow()

    fun onEvent(event: PokemonEvent) = when(event) {
        is PokemonEvent.RetrievePokemon -> retrievePokemon(event.pokedexOrder)
    }

    private fun retrievePokemon(pokedexOrder: Int) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    loading = true,
                    pokemon = null
                )
            }

            retrievePokemonUseCase(pokedexOrder).fold(
                ifLeft = {
                    // TODO Error case
                },
                ifRight = { pokemon ->
                    _state.update { currentState ->
                        currentState.copy(
                            pokemon = pokemon.toPokemonUIModel(),
                            loading = false
                        )
                    }
                }
            )
        }
    }
}