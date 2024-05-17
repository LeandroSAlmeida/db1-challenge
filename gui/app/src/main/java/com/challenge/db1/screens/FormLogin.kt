package com.challenge.db1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun FormLogin(navController: NavController) {

    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(13.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
            contentDescription = "Logo",
            Modifier
                .size(300.dp)
                .offset(y = (-10).dp)
        )
        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 30.dp))
        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .height(380.dp),
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(ColorSecundary, ColorThird))
        ) {
            Column(
                modifier = Modifier.padding(all = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldCustom(
                    value = username,
                    onValueChange = {
                        username = it
                    } ,
                    hint = stringResource(id = R.string.hint_username),
                    KeyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp)
                )

                TextFieldCustom(
                    value = password,
                    onValueChange = {
                        password = it
                    } ,
                    hint = stringResource(id = R.string.hint_password),
                    KeyboardOptions = KeyboardOptions(
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                    icon = R.drawable.icons8_chave

                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate("signup")
                        }
                    )
                    
                    Spacer(modifier = Modifier.padding(70.dp, 0.dp))

                    Text(
                        text = stringResource(id = R.string.txt_forgot_password),
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate("forgotpassword")
                        }

                    )

                }

                Spacer(modifier = Modifier.padding(0.dp, 20.dp))

                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(400.dp)
                        .height(90.dp)
                        .padding(0.dp, 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ColorThird,
                        contentColor = Color.White
                    ),

                    shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_button_login),
                            fontSize = 18.sp
                        )
                }

            }
        }
    }
}



@Composable
@Preview(showSystemUi = true)
private fun FormLoginPreview() {
    val navController = rememberNavController()
    FormLogin(navController = navController)
}
