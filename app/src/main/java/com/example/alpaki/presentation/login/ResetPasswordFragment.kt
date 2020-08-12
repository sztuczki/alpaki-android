package com.example.alpaki.presentation.login

import androidx.fragment.app.viewModels
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentRegisterBinding
import com.example.alpaki.presentation.fragments.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : BaseFragment<FragmentRegisterBinding>() {

    override val layoutId: Int = R.layout.fragment_reset_password

    private val resetPasswordViewModel: RegisterViewModel by viewModels()

}
