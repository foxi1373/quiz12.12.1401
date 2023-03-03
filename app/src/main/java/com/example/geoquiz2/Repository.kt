package com.example.geoquiz2

class Repository {
    private val question1 = Question("A bear is black", false)
    private val question2 = Question("Benz is a car", true)
    private val question3 = Question("I am amazing", true)
    private val question4 = Question("A cloud rains", false)
    private val question5 = Question("The sun is hot", true)
    private val question6 = Question("Mohammad is just a name", false)
    private val question7 = Question("A bird can fly", false)
    private val question8 = Question("A lion can hunt", true)
    private val question9 = Question("A deer has antler", false)
    private val question10 = Question("A bear is black", false)
    val questions = arrayOf(
        question1,
        question2,
        question3,
        question4,
        question5,
        question6,
        question7,
        question8,
        question9,
        question10
    )
}