package com.example.geoquiz2

data class Question(
    val text: String,
    val answer: Boolean,
    var isCheated: Boolean = false,
    var isAnswered: Boolean = false,
    var correctAnswer: String = "",
)