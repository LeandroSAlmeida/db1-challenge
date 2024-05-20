// MockViewModel.kt
package com.challenge.db1.network

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.db1.domain.AlunoEProfessor
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class MockViewModel : ViewModel() {
    val mockData = mutableStateOf<List<AlunoEProfessor>>(emptyList())
    val isLoading = mutableStateOf(true)
    val errorMessage = mutableStateOf("")

    init {
        fetchMockData()
    }

    private fun fetchMockData() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RestApiModule.apiService.getMockData().awaitResponse()
                }
                if (response.isSuccessful) {
                    mockData.value = response.body()?.map {
                        AlunoEProfessor(
                            name = it.name,
                            avatar = "", // Atualize conforme necessário
                            isMentor = it.isMentor ?: false,
                            habilities = it.habilities ?: "",
                            interests = it.interests ?: "",
                            academic_education = it.academic_education
                        )
                    } ?: emptyList()
                } else {
                    errorMessage.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Exception: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}
