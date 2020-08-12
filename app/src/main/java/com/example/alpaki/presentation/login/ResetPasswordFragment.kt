package com.example.alpaki.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentResetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_register.*

@AndroidEntryPoint
class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>() {

    override val layoutId: Int = R.layout.fragment_reset_password

    private val resetPasswordViewModel: ResetPasswordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = resetPasswordViewModel

        titleBarView.setLeftIconClickListener { requireActivity().onBackPressed() }
    }
}
