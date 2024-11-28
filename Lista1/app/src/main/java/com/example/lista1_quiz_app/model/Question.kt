package com.example.lista1_quiz_app.model

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)


