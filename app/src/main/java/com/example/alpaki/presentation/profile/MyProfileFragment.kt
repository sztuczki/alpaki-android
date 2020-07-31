package com.example.alpaki.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentMyProfileBinding
import com.example.alpaki.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class MyProfileFragment : BaseFragment<FragmentMyProfileBinding>() {

    val testImageUrl ="https://lh3.googleusercontent.com/proxy/yB6IHKUYfKwZ_HbB2tRSqlXAgszjdWcRb30kvavvWo_CZXQ_KMJ1VHhtmXnb5t_Pp-Ar84HifAYkhZvmhXKgwI_sTg1wWuLSfSordq7g7fQsoNEs8gCOsiuH_BOJY9pDW028oRoVUz37z9TrQg"
    val testActive = false

    override val layoutId: Int = R.layout.fragment_my_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tmp = this
    }

}