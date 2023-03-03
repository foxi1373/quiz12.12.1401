package com.example.geoquiz2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.geoquiz2.databinding.FragmentCheatBinding

class CheatFragment : Fragment(R.layout.fragment_cheat) {
    private lateinit var binding : FragmentCheatBinding
    private val viewModel : QuizViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheatBinding.bind(view)
        binding.apply {
            quizViewModel = viewModel
            lifecycleOwner = this@CheatFragment
            binding.showAnswer.setOnClickListener {
                binding.answer.text = viewModel.questions[viewModel.currentQuestionInd].answer.toString()
                viewModel.questions[viewModel.currentQuestionInd].isCheated = true
            }
        }
    }
}