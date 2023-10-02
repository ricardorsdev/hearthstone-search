package com.ricardorsdev.hearthstonesearch.domain.repository

import com.ricardorsdev.hearthstonesearch.domain.model.Card

interface CardRepository {

    suspend fun getCards(page: Int, tier: Int? = null): List<Card>
    suspend fun getCardDetail(cardId: Int): Card
}