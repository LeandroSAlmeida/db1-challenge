import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.challenge.db1.R
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun ProfileScreen(
    alunoEProfessor: AlunoEProfessor,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Adiciona scroll vertical
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Image(
            painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(350.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = alunoEProfessor.name,
            style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Interesses: ${alunoEProfessor.interests}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Habilidades: ${alunoEProfessor.habilities}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Formação: ${alunoEProfessor.academic_education}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Implementando a lógica de match
                    val match = verificarMatch(alunoEProfessor)
                    if (match) {
                        navController.navigate("match")
                    } else {
                        navController.navigate("dashboard")
                    } },
                colors = ButtonDefaults.buttonColors(ColorThird)
            ) {
                Text(text = "Match", color = Color.White)
            }
            Button(
                onClick = { navController.navigate("dashboard") },
                colors = ButtonDefaults.buttonColors(ColorThird)
            ) {
                Text(text = "Não", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}


// Função para verificar se houve match entre dois perfis
fun verificarMatch(alunoEProfessor: AlunoEProfessor): Boolean {
    // Aqui você define a lógica de match
    // Por exemplo, um match ocorre se os interesses de um perfil forem as habilidades do outro e vice-versa
    // Vou implementar uma lógica simples de match para demonstração

    // Condição para match: interesses do alunoEProfessor são as habilidades do usuário atual e vice-versa
    val match = alunoEProfessor.habilities.contains(alunoEProfessor.interests, ignoreCase = true) &&
            alunoEProfessor.interests.contains(alunoEProfessor.habilities, ignoreCase = true)

    return match
}

//@Preview
//@Composable
//fun ProfileScreenPreview() {
//    ProfileScreen(
//        alunoEProfessor = AlunoEProfessor(
//            name = "João",
//            avatar = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/732.jpg",
//            isMentor = false,
//            interests = "Programação, Design",
//            habilities = "Kotlin, Android",
//            academic_education = "Engenharia de Software"
//        ),
//        navController = NavController()
//    )
//}
