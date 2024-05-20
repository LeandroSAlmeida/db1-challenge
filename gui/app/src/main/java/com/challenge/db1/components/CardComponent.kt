import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.db1.R
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun CardComponent(
    alunoEProfessor: AlunoEProfessor,
    onCardClicked: () -> Unit, // Adiciona o callback como parâmetro
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable { onCardClicked() } // Adiciona o evento de clique
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
                .background(Color.White)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                ColorThird,
                                Color.White
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
                    contentDescription = "Image",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Text(
                text = alunoEProfessor.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = alunoEProfessor.habilities,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            alunoEProfessor.academic_education?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
