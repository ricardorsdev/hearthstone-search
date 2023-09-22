package com.ricardorsdev.hearthstonesearch.core.di

import android.content.Context
import android.content.SharedPreferences
import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import com.ricardorsdev.hearthstonesearch.data.remote.ApiInterceptor
import com.ricardorsdev.hearthstonesearch.data.remote.AuthApiService
import com.ricardorsdev.hearthstonesearch.data.remote.AuthAuthenticator
import com.ricardorsdev.hearthstonesearch.data.remote.HearthstoneApiService
import com.ricardorsdev.hearthstonesearch.data.repository.CardRepositoryImpl
import com.ricardorsdev.hearthstonesearch.domain.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesApiInterceptor(sharedPreferences: SharedPreferences): ApiInterceptor {
        return ApiInterceptor(sharedPreferences)
    }

    @Provides
    @Singleton
    fun providesAuthenticator(service: AuthApiService, sharedPreferences: SharedPreferences): AuthAuthenticator {
        return AuthAuthenticator(service, sharedPreferences)
    }

    @Provides
    @Singleton
    @Named("ApiClient")
    fun providesApiHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        apiInterceptor: ApiInterceptor,
        authAuthenticator: AuthAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiInterceptor)
            .authenticator(authAuthenticator)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(@Named("ApiClient") okHttpClient: OkHttpClient): HearthstoneApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HearthstoneApiService::class.java)
    }

    @Provides
    @Singleton
    @Named("AuthClient")
    fun providesAuthHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesAuthService(@Named("AuthClient") okHttpClient: OkHttpClient): AuthApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.AUTH_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesCardRepository(api: HearthstoneApiService): CardRepository {
        return CardRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(Constants.HEARTHSTONE_SHARED_PREFS, Context.MODE_PRIVATE)
    }
}