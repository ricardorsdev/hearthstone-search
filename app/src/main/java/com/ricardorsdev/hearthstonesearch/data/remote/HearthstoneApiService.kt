package com.ricardorsdev.hearthstonesearch.data.remote

import com.ricardorsdev.hearthstonesearch.data.remote.dto.CardDto
import com.ricardorsdev.hearthstonesearch.data.remote.dto.CardResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HearthstoneApiService {

    @GET("cards")
    suspend fun getCards(): CardResponseDto

    @GET("cards/{cardId}")
    suspend fun getCardDetail(@Path("cardId") cardId: Int): CardDto
}