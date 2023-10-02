package com.ricardorsdev.hearthstonesearch.data.repository

import com.ricardorsdev.hearthstonesearch.core.commons.Constants.FINAL_TIER
import com.ricardorsdev.hearthstonesearch.core.commons.Constants.INITIAL_TIER
import com.ricardorsdev.hearthstonesearch.data.remote.HearthstoneApiService
import com.ricardorsdev.hearthstonesearch.data.remote.dto.toCard
import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val service: HearthstoneApiService
) : CardRepository {
    override suspend fun getCards(page: Int, tier: Int?): List<Card> {
        return service.getCards(
            page = page,
            tier = getTierAsQueryString(tier)
        ).cards.map { it.toCard() }
    }

    override suspend fun getCardDetail(cardId: Int): Card {
        return service.getCardDetail(cardId).toCard()
    }

    private fun getTierAsQueryString(tier: Int?): String {
        return tier?.toString() ?: (INITIAL_TIER..FINAL_TIER).joinToString(",")
    }
}