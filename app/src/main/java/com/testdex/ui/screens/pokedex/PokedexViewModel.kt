package com.testdex.ui.screens.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdex.domain.use_case.RetrievePokemonListUseCase
import com.testdex.ui.utils.UIConstants
import com.testdex.ui.utils.toPokemonUIModelList
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

    private var _minimumPokemon = UIConstants.MIN_POKEMON_NUMBER_ON_A_PAGE

    fun onEvent(event: PokedexEvent) = when(event) {
        is PokedexEvent.RetrievePokemonList -> retrievePokemonList()
        is PokedexEvent.SearchPokemonByName -> {}
    }

    private fun retrievePokemonList() {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    loading = _minimumPokemon == UIConstants.MIN_POKEMON_NUMBER_ON_A_PAGE,
                    loadingMore = _minimumPokemon > UIConstants.MIN_POKEMON_NUMBER_ON_A_PAGE
                )
            }

            retrievePokemonListUseCase(_minimumPokemon).fold(
                ifLeft = {
                    // TODO Error case
                },
                ifRight = { newPokemonList ->
                    _state.update { currentState ->
                        currentState.copy(
                            pokemonList = state.value.pokemonList + newPokemonList.toPokemonUIModelList(),
                            loading = false,
                            loadingMore = false
                        )
                    }
                    _minimumPokemon += UIConstants.MAX_POKEMON_NUMBER_ON_A_PAGE
                }
            )
        }
    }
}