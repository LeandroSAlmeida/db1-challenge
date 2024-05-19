package com.challenge.db1.components

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.challenge.db1.domain.AlunoEProfessor
import com.challenge.db1.sampledata.SampleAlunos

@Composable
fun UsersSection(
    title: String,
    alunosEProfessor: List<AlunoEProfessor>
) {
    Column {
        Text(
            text = title,
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight(400),
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            for (p in alunosEProfessor){
                CardComponent(alunoEProfessor = p)
            }

            Spacer(Modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserSectionPreview() {
    UsersSection(title = "Front", alunosEProfessor =  SampleAlunos)
    CardComponent(
        AlunoEProfessor(
            name = "Leandro", null, true, "Java", "Programar", "Fiap"
        )
    )
    CardComponent(
        AlunoEProfessor(
            name = "teste", null, true, "Java", "Programar", "Fiap"
        )
    )
    CardComponent(
        AlunoEProfessor(
            name = "teste", null, true, "Java", "Programar", "Fiap"
        )
    )
}
