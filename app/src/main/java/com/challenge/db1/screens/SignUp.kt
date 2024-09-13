package com.challenge.db1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.R
import com.challenge.db1.components.AnimatedBorderCard
import com.challenge.db1.components.TextFieldCustom
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorSecundary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun SignUp(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isTeacher by remember { mutableStateOf(false) }
    var isStudent by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .offset(y = (-10).dp)
        )
        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .height(1000.dp), // Ajuste a altura conforme necessário
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(ColorSecundary, ColorThird))
        ) {
            Column(
                modifier = Modifier.padding(all = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldCustom(
                    value = username,
                    onValueChange = { username = it },
                    hint = stringResource(id = R.string.hint_username),
                    KeyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp)
                )

                TextFieldCustom(
                    value = email,
                    onValueChange = { email = it },
                    hint = stringResource(id = R.string.hint_email),
                    KeyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                    icon = R.drawable.baseline_attach_email_24
                )

                TextFieldCustom(
                    value = password,
                    onValueChange = { password = it },
                    hint = stringResource(id = R.string.hint_password),
                    KeyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                    icon = R.drawable.icons8_chave
                )
                Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ColorPrimary)
                        .padding(end = 20.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        fontSize = 15.sp,
                        color = Color.White,
                        text = "Você é"

                    )
                    // Conteúdo existente...

                    Spacer(modifier = Modifier.padding(2.dp, 5.dp))

                    // Row para "Sou professor" e "Sou aluno"
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Caixa de seleção para "Sou professor"
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isTeacher,
                                onCheckedChange = { isChecked -> isTeacher = isChecked },
                                modifier = Modifier.padding(end = 2.dp)
                            )

                            Text(
                                text = "Sou professor",
                                color = Color.White
                            )
                        }

                        // Caixa de seleção para "Sou aluno"
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isStudent,
                                onCheckedChange = { isChecked -> isStudent = isChecked },
                                modifier = Modifier.padding(end = 8.dp)
                            )

                            Text(
                                text = "Sou aluno",
                                color = Color.White
                            )
                        }
                    }


                    Button(
                        onClick = {
                            navController.navigate("skills")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp) // Ajuste a altura conforme necessário
                            .padding(10.dp, 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ColorThird,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_button_skills),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun FormLoginPreview() {
    // Como a função FormLogin precisa de um NavController como parâmetro,
    // vamos criar um NavController falso para uso na pré-visualização.
    val navController = rememberNavController()

    // Em seguida, chamamos a função FormLogin passando o NavController falso.
    SignUp(navController = navController)
}