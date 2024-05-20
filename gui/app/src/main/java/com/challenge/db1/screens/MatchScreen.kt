package com.challenge.db1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.challenge.db1.R
import com.challenge.db1.components.AnimatedBorderCard
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorSecundary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun MatchScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(76.dp))
        AnimatedBorderCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(ColorSecundary, ColorThird))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "MATCH !!!",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(200.dp))
        Button(
            onClick = {
                navController.navigate("login") },
            modifier = Modifier.fillMaxWidth()
                .size(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorThird,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Voltar",
                fontSize = 25.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MatchScreenPreview() {
    val navController = rememberNavController()
    MatchScreen(navController)
}
