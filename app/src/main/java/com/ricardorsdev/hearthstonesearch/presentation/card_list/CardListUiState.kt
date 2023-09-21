package com.ricardorsdev.hearthstonesearch.presentation.card_list

import com.ricardorsdev.hearthstonesearch.domain.model.Card

sealed interface CardListUiState {
    object Loading : CardListUiState
    data class Error(val error: String) : CardListUiState
    data class Success(val cards: List<Card> = emptyList()) : CardListUiState
}