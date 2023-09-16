package com.ricardorsdev.hearthstonesearch.presentation.card_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.use_case.get_cards.GetCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase
): ViewModel() {

    private var _state = MutableStateFlow<CardListUiState>(CardListUiState.Loading)
    val state = _state

    init {
        getCards()
    }

    private fun getCards() {
        getCardsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = CardListUiState.Loading
                }

                is Resource.Success -> {
                    _state.value = CardListUiState.Success(
                        items = resource.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = CardListUiState.Error(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}