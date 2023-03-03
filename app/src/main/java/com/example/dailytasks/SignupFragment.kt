package com.example.dailytasks

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.*
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
            val nullObserver = Observer<Boolean> {
                if (it)
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<LoginFragment>(R.id.fragment_container_view)
                        addToBackStack(null)
                    }
                else
                    viewModel.makeToast(toast)
            }
            viewModel.isNull().observe(viewLifecycleOwner, nullObserver)
            binding.singUp2.setOnClickListener {
                viewModel.updateDataSignup(
                    binding.UserName2.text.toString(),
                    binding.Password2.text.toString()
                )
            }
        }
    }
}