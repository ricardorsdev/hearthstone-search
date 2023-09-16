package com.ricardorsdev.hearthstonesearch.data.repository

import com.ricardorsdev.hearthstonesearch.data.remote.HearthstoneApi
import com.ricardorsdev.hearthstonesearch.data.remote.dto.toCard
import com.ricardorsdev.hearthstonesearch.domain.model.Card
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor (
    private val api: HearthstoneApi
): CardRepository {
    override suspend fun getCards(): List<Card> {
        return api.getCards().cards.map { it.toCard() }
    }
}