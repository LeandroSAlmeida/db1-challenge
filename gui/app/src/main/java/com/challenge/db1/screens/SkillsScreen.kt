import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.R
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun SkillsScreen(navController: NavController) {
    var experience by remember { mutableStateOf("Sem experiência") }
    var interest by remember { mutableStateOf("Selecione uma área de interesse") }
    var skills by remember { mutableStateOf(mutableSetOf<String>()) }
    var skillArea by remember { mutableStateOf("Selecione a área de atuação") }
    var education by remember { mutableStateOf("Selecione a formação acadêmica") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp), // Espaço extra para o botão "Register"
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Informações de Skills",
            color = Color.White,
            fontSize = 24.sp
        )

        SelectionDropDown(
            title = "Experiência",
            options = listOf("Sem experiência", "1 ano", "2 anos", "3 anos", "+ de 4 anos"),
            selectedOption = experience,
            onOptionSelected = { experience = it }
        )


        SelectionDropDown(
            title = "Áreas de Interesse",
            options = listOf("Front-end", "Back-end"),
            selectedOption = interest,
            onOptionSelected = { interest = it }
        )


        SkillSelection(
            title = "Habilidades",
            options = listOf("Java", "JavaScript", "React", "C#", "TypeScript", "Kotlin", "SQL"),
            selectedOptions = skills,
            onOptionSelected = { skills = it }
        )


        SelectionDropDown(
            title = "Área de Atuação",
            options = listOf("Front-end", "Back-end"),
            selectedOption = skillArea,
            onOptionSelected = { skillArea = it }
        )


        SelectionDropDown(
            title = "Formação Acadêmica",
            options = listOf("Graduado", "Não Graduado", "Cursando"),
            selectedOption = education,
            onOptionSelected = { education = it }
        )


        Button(
            onClick = {
                // Lógica de cadastro aqui
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp, 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorThird,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.txt_button_register),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun SelectionDropDown(
    title: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onOptionSelected(option) }
                )
                Text(
                    text = option,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun SkillSelection(
    title: String,
    options: List<String>,
    selectedOptions: MutableSet<String>,
    onOptionSelected: (MutableSet<String>) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Checkbox(
                    checked = selectedOptions.contains(option),
                    onCheckedChange = {
                        val newOptions = selectedOptions.toMutableSet()
                        if (it) {
                            newOptions.add(option)
                        } else {
                            newOptions.remove(option)
                        }
                        onOptionSelected(newOptions)
                    }
                )
                Text(
                    text = option,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun SkillScreen() {
    val navController = rememberNavController()
    SkillsScreen(navController = navController)
}