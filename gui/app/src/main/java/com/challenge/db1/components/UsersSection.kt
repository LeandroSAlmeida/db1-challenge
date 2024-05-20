import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.db1.domain.AlunoEProfessor

@Composable
fun UsersSection(
    title: String,
    alunosEProfessor: List<AlunoEProfessor>,
    onCardClicked: (AlunoEProfessor) -> Unit, // Adiciona o callback como parâmetro
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            color = Color.White
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(alunosEProfessor) { p ->
                CardComponent(
                    alunoEProfessor = p,
                    onCardClicked = { onCardClicked(p) }, // Adiciona o evento de clique
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}
