package com.challenge.db1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiModule {
    private const val BASE_URL = "https://664b0aefa300e8795d43f89a.mockapi.io/"

    val apiService: RestApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApiService::class.java)
    }
}
