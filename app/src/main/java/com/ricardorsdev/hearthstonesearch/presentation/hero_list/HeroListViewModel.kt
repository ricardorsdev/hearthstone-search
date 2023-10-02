package com.ricardorsdev.hearthstonesearch.presentation.hero_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.use_case.get_heroes.GetHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val getHeroesUseCase: GetHeroesUseCase
): ViewModel() {

    private var _state: MutableState<HeroListUiState> = mutableStateOf(HeroListUiState.Loading)
    val state = _state

    private var currentPage = 1

    init {
        getHeroes()
    }

    private fun getHeroes() {
        getHeroesUseCase(currentPage).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = HeroListUiState.Loading
                }

                is Resource.Success -> {
                    _state.value = HeroListUiState.Success(
                        heroes = resource.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = HeroListUiState.Error(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}