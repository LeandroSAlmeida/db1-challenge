package com.challenge.db1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
    alunosEProfessor: List<AlunoEProfessor>,
    modifier: Modifier = Modifier,
    
) {
    Column(modifier) {
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
        LazyRow(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {


            items(alunosEProfessor){p -> CardComponent(alunoEProfessor = p)
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun UserSectionPreview() {
    UsersSection(title = "Front", alunosEProfessor = SampleAlunos)
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
