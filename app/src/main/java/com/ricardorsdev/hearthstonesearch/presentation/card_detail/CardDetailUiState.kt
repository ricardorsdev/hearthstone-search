package com.ricardorsdev.hearthstonesearch.presentation.card_detail

import com.ricardorsdev.hearthstonesearch.domain.model.Card

sealed interface CardDetailUiState {
    object Loading : CardDetailUiState
    data class Error(val error: String) : CardDetailUiState
    data class Success(val card: Card? = null) : CardDetailUiState
}