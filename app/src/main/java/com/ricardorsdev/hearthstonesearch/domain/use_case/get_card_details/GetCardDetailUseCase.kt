package com.ricardorsdev.hearthstonesearch.domain.use_case.get_card_details

import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.model.Resource
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCardDetailUseCase @Inject constructor(
    private val repository: CardRepository
) {

    operator fun invoke(cardId: String): Flow<Resource<Card>> = flow {
        try {
            emit(Resource.Loading<Card>())
            val card = repository.getCardDetail(cardId.toInt())
            emit(Resource.Success<Card>(card))
        } catch(e: HttpException) {
            emit(Resource.Error<Card>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<Card>("Couldn't reach server. Check your internet connection."))
        }
    }
}