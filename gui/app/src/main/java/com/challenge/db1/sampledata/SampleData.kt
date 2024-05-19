package com.challenge.db1.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.challenge.db1.domain.AlunoEProfessor

val SampleAlunos = listOf(
    AlunoEProfessor(
        name = "Aluno1",
        null,
        true,
        "Java",
        "Programar",
         academic_education = LoremIpsum(20).values.first()
    ),
    AlunoEProfessor(
        name = "Aluno2",
        "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/461.jpg",
        true,
        "Java",
        "Programar",
        "React, typescript, javascript, java, c#, html, css,"
    ),

    AlunoEProfessor(
        name = "Aluno3",
        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.flaticon.com%2Fbr%2Ficone-gratis%2Faluno_3413565&psig=AOvVaw2lniMx19rB_-Po4s_avwdB&ust=1716207081949000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLCqn_jXmYYDFQAAAAAdAAAAABAD",
        true,
        "Java",
        "Programar",
        "React, typescript, javascript, java, c#, html, css,"
    )

)

val SampleProfessor = listOf(
    AlunoEProfessor(
        name = "TesteProfessor",
        null,
        true,
        "Java",
        "Programar",
        "React, typescript, javascript, java, c#, html, css,"
    ),
    AlunoEProfessor(
        name = "TesteProfessor2",
        "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/461.jpg",
        true,
        "TypeScript",
        "Programar",
        "React, typescript, javascript, java, c#, html, css,"
    ),

    AlunoEProfessor(
        name = "TesteProfessor3",
        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.flaticon.com%2Fbr%2Ficone-gratis%2Faluno_3413565&psig=AOvVaw2lniMx19rB_-Po4s_avwdB&ust=1716207081949000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLCqn_jXmYYDFQAAAAAdAAAAABAD",
        true,
        "React",
        "Programar",
        "React"
    )
)

val SampleSections = mapOf (
    "alunos" to SampleAlunos,
    "professor" to SampleProfessor
)
