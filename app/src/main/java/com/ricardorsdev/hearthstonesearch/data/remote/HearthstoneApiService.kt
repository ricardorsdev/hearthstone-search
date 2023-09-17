package com.ricardorsdev.hearthstonesearch.data.remote

import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import com.ricardorsdev.hearthstonesearch.data.remote.dto.CardResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HearthstoneApiService {

    @GET("cards")
    suspend fun getCards(): CardResponseDto
}