package com.example.alpaki.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutId: Int = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegister.setOnClickListener {
            openRegisterProcess()
        }
    }

    private fun openRegisterProcess() = findNavController().navigate(R.id.registerFragment)
}
