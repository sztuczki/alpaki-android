package com.example.alpaki.presentation.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutId: Int = R.layout.fragment_profile

    @Inject
    lateinit var profileViewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegister.setOnClickListener {
            openRegisterProcess()
        }

        buttonLogIn.setOnClickListener {
            profileViewModel.logIn(editTextEmail.text.toString(), editTextPassword.text.toString())
        }
    }

    private fun openRegisterProcess() = findNavController().navigate(R.id.registerFragment)
}
