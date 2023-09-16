package com.ricardorsdev.hearthstonesearch.domain.use_case.get_cards

import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(
    private val repository: CardRepository
) {

    operator fun invoke(): Flow<Resource<List<Card>>> = flow {
        try {
            emit(Resource.Loading<List<Card>>())
            val cards = repository.getCards()
            emit(Resource.Success<List<Card>>(cards))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Card>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Card>>("Couldn't reach server. Check your internet connection."))
        }
    }
}