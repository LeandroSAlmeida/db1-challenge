package com.challenge.db1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.challenge.db1.R
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.ui.theme.ColorPrimary

@Composable
fun CardProductItem(
    alunoEProfessor: AlunoEProfessor,
    onCardClicked: (AlunoEProfessor) -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = modifier.clickable { onCardClicked(alunoEProfessor) },
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)

            ) {
                Text(
                    text = alunoEProfessor.name
                )
                Text(
                    text = alunoEProfessor.habilities
                )
            }
            alunoEProfessor.academic_education?.let {
                Text(
                    text = alunoEProfessor.academic_education,
                    Modifier
                        .padding(16.dp)

                )
            }
        }

    }
}


