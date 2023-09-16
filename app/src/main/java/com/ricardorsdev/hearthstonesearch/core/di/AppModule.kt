package com.ricardorsdev.hearthstonesearch.core.di

import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import com.ricardorsdev.hearthstonesearch.data.remote.ApiInterceptor
import com.ricardorsdev.hearthstonesearch.data.remote.HearthstoneApi
import com.ricardorsdev.hearthstonesearch.data.repository.CardRepositoryImpl
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(ApiInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiClient(okHttpClient: OkHttpClient): HearthstoneApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HearthstoneApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCardRepository(api: HearthstoneApi): CardRepository {
        return CardRepositoryImpl(api)
    }
}