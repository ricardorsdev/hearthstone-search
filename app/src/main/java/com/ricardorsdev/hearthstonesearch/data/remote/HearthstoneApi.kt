package com.ricardorsdev.hearthstonesearch.data.remote

import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import com.ricardorsdev.hearthstonesearch.data.remote.dto.CardResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HearthstoneApi {

    @GET("cards")
    suspend fun getCards(
        @Query("locale") locale: String = Constants.DEFAULT_LOCALE,
        @Query("gameMode") gameMode: String = Constants.DEFAULT_GAME_MODE
    ): CardResponseDto
}