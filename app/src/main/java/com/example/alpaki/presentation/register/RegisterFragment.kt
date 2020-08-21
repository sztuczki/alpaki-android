package com.example.alpaki.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.alpaki.R
import com.example.alpaki.core.livedata.wrappers.State
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentRegisterBinding
import com.example.alpaki.presentation.util.isCodeValid
import com.example.alpaki.presentation.util.isEmailValid
import com.example.alpaki.presentation.util.isPasswordValid
import com.example.alpaki.presentation.util.isPhoneValid
import com.example.data.api.BRANDS_LIST
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.item_spinner.*

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
            registerViewModel.brand.value = layoutTextBrand.selectedItem.toString()
            if (isRegisterFormsCorrect()) registerViewModel.register()
        }
        setupViewLiveDataObservers()
        layoutTextBrand.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, R.id.textViewBrand, BRANDS_LIST)

    }

    private fun setupViewLiveDataObservers() {
        with(registerViewModel) {
            success.observe(viewLifecycleOwner, Observer { state ->
                if (state is State.Success) {
                    onRegisterSuccess()
                }
            })
            error.observe(viewLifecycleOwner, Observer { state ->
                if (state is State.Error) {
                    onRegisterError()
                }
            })
        }
    }

    private fun onRegisterSuccess() = openMyProfileFragment()

    private fun onRegisterError() {
        layoutTextName.error = getString(R.string.text_error_register)
        layoutTextSurname.error = getString(R.string.text_error_register)
        layoutTextPhone.error = getString(R.string.text_error_register)
        layoutTextEmail.error = getString(R.string.text_error_register)
        layoutTextPasswordRegister.error = getString(R.string.text_error_register)
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
                password.value.isPasswordValid().not() -> layoutTextPasswordRegister.error =
                    getString(R.string.text_error_missing_field)
                code.value.isCodeValid().not() -> layoutTextActivationCode.error =
                    getString(R.string.text_error_wrong_code)
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

    private fun openMyProfileFragment() = findNavController().navigate(R.id.myProfileFragment)
}
