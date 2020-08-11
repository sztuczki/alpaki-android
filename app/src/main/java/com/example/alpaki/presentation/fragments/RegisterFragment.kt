package com.example.alpaki.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentRegisterBinding
import com.example.alpaki.presentation.util.isEmailValid
import com.example.alpaki.presentation.util.isPasswordValid
import com.example.alpaki.presentation.util.isPhoneValid
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.layoutTextEmail

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override val layoutId: Int = R.layout.fragment_register

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = registerViewModel

        titleBarView.setLeftIconClickListener { requireActivity().onBackPressed() }

        buttonNext.setOnClickListener {
            cleanErrors()
            if (isRegisterFormsCorrect()) registerViewModel.register()
        }
    }

    private fun isRegisterFormsCorrect(): Boolean {
        with(registerViewModel) {
            when {
                name.value.isNullOrEmpty() -> layoutTextName.error =
                    getString(R.string.text_error_missing_field)
                surname.value.isNullOrEmpty() -> layoutTextSurname.error =
                    getString(R.string.text_error_missing_field)
                phone.value.isPhoneValid().not() -> layoutTextPhone.error =
                    getString(R.string.text_error_wrong_phone)
                email.value.isEmailValid().not() -> layoutTextEmail.error =
                    getString(R.string.text_error_wrong_email)
                password.value.isPasswordValid() -> layoutTextPasswordRegister.error =
                    getString(R.string.text_error_missing_field)
                activationCode.value.isNullOrEmpty() -> layoutTextActivationCode.error =
                    getString(R.string.text_error_missing_field)
                else -> return true
            }
            return false
        }
    }

    private fun cleanErrors() {
        layoutTextName.isErrorEnabled = false
        layoutTextSurname.isErrorEnabled = false
        layoutTextPhone.isErrorEnabled = false
        layoutTextEmail.isErrorEnabled = false
        layoutTextPasswordRegister.isErrorEnabled = false
        layoutTextActivationCode.isErrorEnabled = false
    }
}
