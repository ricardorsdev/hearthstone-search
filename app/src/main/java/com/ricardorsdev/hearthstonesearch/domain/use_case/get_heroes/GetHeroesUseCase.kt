package com.ricardorsdev.hearthstonesearch.domain.use_case.get_heroes

import com.ricardorsdev.hearthstonesearch.core.commons.Constants.HERO_TIER
import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    private val repository: CardRepository
) {
    operator fun invoke(page: Int): Flow<Resource<List<Card>>> = flow {
        try {
            emit(Resource.Loading<List<Card>>())
            val cards = repository.getCards(page = page, tier = HERO_TIER)
            emit(Resource.Success<List<Card>>(cards))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Card>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Card>>("Couldn't reach server. Check your internet connection."))
        }
    }
}