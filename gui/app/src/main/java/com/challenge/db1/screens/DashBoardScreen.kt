import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun DashboardScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    val students = listOf("Aluno 1", "Aluno 2", "Aluno 3", "Aluno 4", "Aluno 5")
    val professors = listOf("Professor 1", "Professor 2", "Professor 3", "Professor 4", "Professor 5")

    val filteredStudents = students.filter { it.contains(searchText, ignoreCase = true) }
    val filteredProfessors = professors.filter { it.contains(searchText, ignoreCase = true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Campo de Pesquisa Avançada
        SearchTextField(
            searchText = searchText,
            onSearchChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Lista de Alunos
        Text(
            text = "Alunos",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        filteredStudents.forEach { student ->
            Text(
                text = student,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        // Espaçamento entre as listas
        Spacer(modifier = Modifier.height(24.dp))

        // Lista de Professores
        Text(
            text = "Professores",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        filteredProfessors.forEach { professor ->
            Text(
                text = professor,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de Ação
        Button(
            onClick = { /* Ação do botão */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorThird,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Pesquisar",
                fontSize = 18.sp
            )
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
            .padding(horizontal = 16.dp, vertical = 12.dp)
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

@Composable
@Preview(showSystemUi = true)
private fun DashBoardScreen() {
    val navController = rememberNavController()
    DashboardScreen(navController = navController)
}
