package com.ricardorsdev.hearthstonesearch.data.remote

import android.content.SharedPreferences
import android.util.Log
import com.ricardorsdev.hearthstonesearch.core.commons.Constants
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Credentials
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class AuthAuthenticator @Inject constructor(
    private val service: AuthApiService,
    private val sharedPreferences: SharedPreferences
) : Authenticator {

    companion object {
        const val AUTH_AUTHENTICATOR_CLASS = "AuthAuthenticator"
    }

    private var accessToken = ""
    private val credentials = Credentials.basic(Constants.CLIENT_ID, Constants.CLIENT_SECRET)
    private val Response.responseCount: Int
        get() = generateSequence(this) { it.priorResponse }.count()

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.responseCount >= 3) {
            return null
        }

        runBlocking {
            try {
                val refreshTokenResponse = service.refreshToken(credentials)
                accessToken = refreshTokenResponse.accessToken

                sharedPreferences.edit()
                    .putString(Constants.PREFS_ACCESS_TOKEN, accessToken).apply()
            } catch (e: Exception) {
                Log.e(AUTH_AUTHENTICATOR_CLASS, e.message ?: "An unexpected error occurred.")
            }
        }

        return if (accessToken.isNotBlank()) {
            response.request.newBuilder()
                .header(Constants.PARAM_AUTHORIZATION, Constants.BEARER_ACCESS_TOKEN + accessToken)
                .build()
        } else {
            response.request
        }
    }

}