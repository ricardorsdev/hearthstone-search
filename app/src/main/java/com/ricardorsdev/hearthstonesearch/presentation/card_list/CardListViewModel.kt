package com.ricardorsdev.hearthstonesearch.presentation.card_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.use_case.get_cards.GetCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase
) : ViewModel() {

    private var currentPage = 1

    var cardList = mutableStateOf<List<Card>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    init {
        getCards()
    }

    fun getCards() {
        getCardsUseCase(currentPage).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { cards ->
                        endReached.value = cards.isEmpty()
                        currentPage++

                        loadError.value = ""
                        isLoading.value = false
                        cardList.value += cards
                    }
                }

                is Resource.Error -> {
                    loadError.value = resource.message ?: "An unexpected error occurred"
                    isLoading.value = false
                }

                is Resource.Loading -> {
                    isLoading.value = true
                }
            }
        }.launchIn(viewModelScope)
    }
}