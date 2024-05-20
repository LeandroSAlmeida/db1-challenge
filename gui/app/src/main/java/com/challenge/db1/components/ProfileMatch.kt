import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.db1.R
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorSecundary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun ProfileScreen(
    alunoEProfessor: AlunoEProfessor,
    onMatchClicked: () -> Unit,
    onRejectClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
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
                .offset(y = (-40).dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = alunoEProfessor.name,
            style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp)
                .offset(y = (-50).dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Interesses: ${alunoEProfessor.interests}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(horizontal = 16.dp)
                .offset(y = (-50).dp)
        )

        Text(
            text = "Habilidades: ${alunoEProfessor.habilities}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "Formação: ${alunoEProfessor.academic_education}",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onMatchClicked,
                colors = ButtonDefaults.buttonColors(ColorThird)
            ) {
                Text(text = "Match", color = Color.White)
            }
            Button(
                onClick = onRejectClicked,
                colors = ButtonDefaults.buttonColors(ColorThird)
            ) {
                Text(text = "Não", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val alunoEProfessor = AlunoEProfessor(
        name = "João",
        avatar = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/732.jpg",
        isMentor = false,
        interests = "Programação, Design",
        habilities = "Kotlin, Android",
        academic_education = "Engenharia de Software"
    )

    ProfileScreen(
        alunoEProfessor = alunoEProfessor,
        onMatchClicked = {},
        onRejectClicked = {}
    )
}
