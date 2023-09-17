package com.ricardorsdev.hearthstonesearch.data.remote

import android.content.SharedPreferences
import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiInterceptor(
    private val sharedPreferences: SharedPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val accessToken = sharedPreferences.getString(Constants.PREFS_ACCESS_TOKEN, "")

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(Constants.PARAM_LOCALE, Constants.DEFAULT_LOCALE)
            .addQueryParameter(Constants.PARAM_GAME_MODE, Constants.DEFAULT_GAME_MODE)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder()
            .header(Constants.PARAM_AUTHORIZATION, Constants.BEARER_ACCESS_TOKEN + accessToken)
            .url(url)

        return chain.proceed(requestBuilder.build())
    }
}