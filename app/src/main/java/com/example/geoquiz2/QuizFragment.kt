package com.example.geoquiz2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.geoquiz2.databinding.FragmentQuizBinding

class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private lateinit var binding: FragmentQuizBinding
    private val viewModel: QuizViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizBinding.bind(view)
        binding.apply {
            quizViewModel = viewModel
            lifecycleOwner = this@QuizFragment


            binding.trueBtn.setOnClickListener {
                viewModel.setIsAnswered()
                showCorrection(viewModel.showResult(viewModel.setCorrection(true)))
            }

            binding.falseBtn.setOnClickListener {
                viewModel.setIsAnswered()
                showCorrection(viewModel.showResult(viewModel.setCorrection(false)))
            }

            binding.next.setOnClickListener {
                viewModel.goToNextOrPrevQuestion(1)
            }

            binding.prev.setOnClickListener {
                viewModel.goToNextOrPrevQuestion(-1)
            }

            binding.cheat.setOnClickListener {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<CheatFragment>(R.id.fragment_container_view)
                    addToBackStack(null)
                }
            }

        }
    }

    private fun showCorrection(correctionMessage: String) {
        Toast.makeText(requireContext(), correctionMessage, Toast.LENGTH_LONG).show()
    }

}