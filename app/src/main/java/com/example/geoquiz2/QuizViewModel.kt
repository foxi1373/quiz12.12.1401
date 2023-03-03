package com.example.geoquiz2

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    var questions: Array<Question> = Repository().questions
    var currentQuestionInd = 0
    private var point: Double = 0.0
    val liveCurrentQuestionText = MutableLiveData(questions[currentQuestionInd].text)
    val liveCurrentQuestionIsAnswered = MutableLiveData(questions[currentQuestionInd].isAnswered)
    val livePoint = MutableLiveData(point)


    fun setIsAnswered(){
        questions[currentQuestionInd].isAnswered = true
        liveCurrentQuestionIsAnswered.value = true
    }

    fun setCorrection(answer: Boolean): Boolean = questions[currentQuestionInd].answer == answer

    private fun setPoint(correct: Boolean) {
        if (correct && !questions[currentQuestionInd].isCheated)
            point += 1
        else if (!correct)
            point -= 1.0/3.0
        livePoint.value = point
    }

    fun showResult(correct: Boolean): String {
        setPoint(correct)
        if (correct && !questions[currentQuestionInd].isCheated)
            return "correct"
        else if (!correct)
            return "wrong"
        return "cheating is wrong"
    }

    @SuppressLint("SuspiciousIndentation")
    fun goToNextOrPrevQuestion(step: Int) {
        if (currentQuestionInd + step in 0..9) {
            currentQuestionInd += step
            liveCurrentQuestionText.value = questions[currentQuestionInd].text
            liveCurrentQuestionIsAnswered.value = questions[currentQuestionInd].isAnswered
        }
    }




}