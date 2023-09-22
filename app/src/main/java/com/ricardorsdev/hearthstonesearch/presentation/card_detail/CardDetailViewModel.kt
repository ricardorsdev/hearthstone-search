package com.ricardorsdev.hearthstonesearch.presentation.card_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.use_case.get_card_details.GetCardDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val getCardDetailUseCase: GetCardDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state: MutableState<CardDetailUiState> = mutableStateOf(CardDetailUiState.Loading)
    val state = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CARD_ID)?.let { coinId ->
            getCardDetail(coinId)
        }
    }

    private fun getCardDetail(coinId: String) {
        getCardDetailUseCase(coinId).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = CardDetailUiState.Loading
                }

                is Resource.Success -> {
                    _state.value = CardDetailUiState.Success(card = resource.data)
                }

                is Resource.Error -> {
                    _state.value = CardDetailUiState.Error(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}