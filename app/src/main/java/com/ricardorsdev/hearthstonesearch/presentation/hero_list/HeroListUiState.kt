package com.ricardorsdev.hearthstonesearch.presentation.hero_list

import com.ricardorsdev.hearthstonesearch.domain.model.Card

sealed interface HeroListUiState {
    object Loading : HeroListUiState
    data class Error(val error: String) : HeroListUiState
    data class Success(val heroes: List<Card> = emptyList()) : HeroListUiState
}