package com.example.alpaki.presentation.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.*

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutId: Int = R.layout.fragment_profile

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegister.setOnClickListener {
            openRegisterProcess()
        }

        buttonLogIn.setOnClickListener {
            profileViewModel.logIn()
        }
    }

    private fun openRegisterProcess() = findNavController().navigate(R.id.registerFragment)
}
