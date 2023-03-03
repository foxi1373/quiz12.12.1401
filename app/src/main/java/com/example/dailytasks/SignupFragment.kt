package com.example.dailytasks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.example.dailytasks.databinding.FragmentSignupBinding

class SignupFragment : Fragment(R.layout.fragment_signup) {
    private lateinit var binding: FragmentSignupBinding
    private val viewModel: RegisterViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupBinding.bind(view)
        binding.apply {
            registerViewModel = viewModel
            lifecycleOwner = this@SignupFragment
            val toast = Toast.makeText(
                requireContext(),
                "username or password is empty",
                Toast.LENGTH_SHORT
            )

            binding.singUp2.setOnClickListener {
                println(viewModel.signupUsername.value)
                viewModel.updateDataSignup(
                    binding.UserName2.text.toString(),
                    binding.Password2.text.toString()
                )

                val nullObserver = Observer<Boolean> {
                    if (!it) {
                        parentFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<LoginFragment>(R.id.fragment_container_view)
                            addToBackStack(null)
                        }
                    } else
                        viewModel.makeToast(toast)
                }
                viewModel.isNull().observe(viewLifecycleOwner, nullObserver)
            }
        }
    }
}