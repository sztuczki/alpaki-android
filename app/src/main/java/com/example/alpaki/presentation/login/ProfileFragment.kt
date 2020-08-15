package com.example.alpaki.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentProfileBinding
import com.example.alpaki.presentation.util.isEmailValid
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.*

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutId: Int = R.layout.fragment_profile

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = profileViewModel
        buttonRegister.setOnClickListener {
            openRegisterProcess()
        }
        textResetPassword.setOnClickListener {
            openResetPasswordFragment()
        }
        buttonLogIn.setOnClickListener {
            clearErrors()
            if (isEmailPasswordCorrect()) profileViewModel.logIn()
        }
    }

    private fun isEmailPasswordCorrect(): Boolean {
        with(profileViewModel) {
             when {
                email.value.isNullOrEmpty() -> layoutTextEmail.error =
                    getString(R.string.text_error_missing_field)
                password.value.isNullOrEmpty() -> layoutTextPassword.error =
                    getString(R.string.text_error_missing_field)
                email.value.isEmailValid().not() -> layoutTextEmail.error =
                    getString(R.string.text_error_wrong_email)
                else -> return true
            }
            return false
        }
    }

    private fun clearErrors() {
        layoutTextEmail.isErrorEnabled = false
        layoutTextPassword.isErrorEnabled = false
    }

    private fun openResetPasswordFragment() = findNavController().navigate(R.id.resetPasswordFragment)

    private fun openRegisterProcess() = findNavController().navigate(R.id.registerFragment)
}
