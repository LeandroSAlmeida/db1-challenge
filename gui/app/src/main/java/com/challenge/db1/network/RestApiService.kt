package com.challenge.db1.network

import retrofit2.http.GET
import retrofit2.Call

data class MockResponse(
    val id: Int,
    val name: String,
    val isMentor: Boolean?,
    val habilities: String,
    val interests: String,
    val academic_education: String?
)

interface RestApiService {
    @GET("/api/v1/users/AlunosEProfessores")
    fun getMockData(): Call<List<MockResponse>>
}
