package com.ricardorsdev.hearthstonesearch.domain.repository

import com.ricardorsdev.hearthstonesearch.domain.model.Card

interface CardRepository {

    suspend fun getCards(): List<Card>
}