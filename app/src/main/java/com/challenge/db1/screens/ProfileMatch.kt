package com.challenge.db1.notification

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.challenge.db1.R
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.ui.theme.ColorThird
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ProfileScreen(
    alunoEProfessor: AlunoEProfessor,
    navController: NavController,
    context: Context // <- Adicionado parâmetro context
) {
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = NotificationHandler(context)

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
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            ),
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
                    // Verificando o match
                    if (verificarMatch(alunoEProfessor)) {
                        notificationHandler.showSimpleNotification(
                            title = "Match Found!",
                            message = "You have a new match with ${alunoEProfessor.name}!"
                        )
                        navController.navigate("match")
                    } else {
                        navController.popBackStack() // Retorna para o Dashboard
                    }
                },
                colors = ButtonDefaults.buttonColors(ColorThird)
            ) {
                Text(text = "Match", color = Color.White)
            }
            Button(
                onClick = { navController.popBackStack() }, // Retorna para o Dashboard
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
    // Simulando a lógica de match (por exemplo, se o aluno é mentor)
    return alunoEProfessor.match
}
