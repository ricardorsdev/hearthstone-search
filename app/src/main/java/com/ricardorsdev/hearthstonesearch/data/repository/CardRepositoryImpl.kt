package com.ricardorsdev.hearthstonesearch.data.repository

import com.ricardorsdev.hearthstonesearch.data.remote.HearthstoneApiService
import com.ricardorsdev.hearthstonesearch.data.remote.dto.toCard
import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor (
    private val service: HearthstoneApiService
): CardRepository {
    override suspend fun getCards(): List<Card> {
        return service.getCards().cards.map { it.toCard() }
    }

    override suspend fun getCardDetail(cardId: Int): Card {
        return service.getCardDetail(cardId).toCard()
    }
}