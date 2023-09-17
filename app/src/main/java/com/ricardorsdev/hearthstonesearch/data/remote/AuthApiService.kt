package com.ricardorsdev.hearthstonesearch.data.remote

import com.ricardorsdev.hearthstonesearch.data.remote.dto.RefreshTokenDto
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {

    @FormUrlEncoded
    @POST("/token")
    suspend fun refreshToken(
        @Header("Authorization") credentials: String,
        @Field("grant_type") grantType: String = "client_credentials"
    ): RefreshTokenDto
}