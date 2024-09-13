package com.challenge.db1.domain

class AlunoEProfessor (
    val id: Int,
    val name: String,
    val avatar: String? = null,
    val isMentor: Boolean,
    val habilities: String,
    val interests: String,
    val academic_education: String? = null,
    var match: Boolean = false
)