package com.example.dailytasks

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.*
import com.example.dailytasks.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: RegisterViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.apply {
            registerViewModel = viewModel
            lifecycleOwner = this@LoginFragment

            binding.singUp.setOnClickListener {
                viewModel.updateDataLogin(binding.UserName.text.toString(), binding.Password.text.toString())
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<SignupFragment>(R.id.fragment_container_view)
                    addToBackStack(null)
                }
            }

            binding.login.setOnClickListener {
                if(viewModel.isCorrect())
                    startActivity(Intent(activity, TaskActivity::class.java))
            }
        }
    }

}