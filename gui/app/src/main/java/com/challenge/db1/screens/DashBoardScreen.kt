import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.components.CardProductItem
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.network.MockViewModel
import com.challenge.db1.ui.theme.ColorPrimary

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: MockViewModel = viewModel()
) {
    var searchText by remember { mutableStateOf("") }
    val mockData by viewModel.mockData
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage

    // Callback para lidar com o clique no card
    val onCardClicked: (AlunoEProfessor) -> Unit = { alunoEProfessor ->
        navController.navigate("profile/${alunoEProfessor.name}")
    }

    val combinedList = mockData

    val searchedAluno = remember(searchText, combinedList) {
        combinedList.filter { alunosEProfessor ->
            alunosEProfessor.name.contains(searchText, ignoreCase = true) ||
                    alunosEProfessor.academic_education?.contains(
                        searchText,
                        ignoreCase = true
                    ) ?: false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(16.dp)
    ) {
        // Campo de Pesquisa Avançada
        SearchTextField(
            searchText = searchText,
            onSearchChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            LazyColumn(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(35.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                if (searchText.isBlank()) {
                    // Mostrar seções quando o campo de pesquisa está vazio
                    for (section in searchedAluno.groupBy { it.habilities }) {
                        val title = section.key
                        val alunosEProfessor = section.value
                        item {
                            UsersSection(
                                title = title,
                                alunosEProfessor = alunosEProfessor,
                                onCardClicked = onCardClicked // Passe o callback
                            )
                        }
                    }
                } else {
                    // Filtrar resultados por habilidade quando há texto no campo de pesquisa
                    val filteredAlunos = searchedAluno.filter { aluno ->
                        aluno.habilities.contains(searchText, ignoreCase = true) ||
                                aluno.name.contains(searchText, ignoreCase = true)
                    }
                    items(filteredAlunos) { alunoOuProfessor ->
                        CardProductItem(
                            alunoEProfessor = alunoOuProfessor,
                            onCardClicked = { onCardClicked(alunoOuProfessor) }, // Chame o callback
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = onSearchChange,
            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        if (searchText.isEmpty()) {
            Text(
                text = "Pesquisa Avançada",
                style = TextStyle(fontSize = 18.sp, color = Color.Gray)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}
