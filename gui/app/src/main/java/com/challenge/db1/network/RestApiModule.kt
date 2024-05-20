package com.challenge.db1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiModule {
    private const val BASE_URL = "https://6638c7ee4253a866a24f2900.mockapi.io/"

    val apiService: RestApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApiService::class.java)
    }
}
