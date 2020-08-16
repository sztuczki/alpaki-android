package com.example.alpaki.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alpaki.DreamModel
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentMyProfileBinding

class MyProfileFragment : BaseFragment<FragmentMyProfileBinding>() {

    val testImageUrl =
        "https://lh3.googleusercontent.com/proxy/yB6IHKUYfKwZ_HbB2tRSqlXAgszjdWcRb30kvavvWo_CZXQ_KMJ1VHhtmXnb5t_Pp-Ar84HifAYkhZvmhXKgwI_sTg1wWuLSfSordq7g7fQsoNEs8gCOsiuH_BOJY9pDW028oRoVUz37z9TrQg"
    val testActive = false

    override val layoutId: Int = R.layout.fragment_my_profile

    lateinit var doneDreamsRecyclerViewAdapter: DreamsRecyclerViewAdapter
    lateinit var activeDreamsRecyclerViewAdapter: DreamsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tmp = this

        setupRecyclersAdapters()
        activeDreamsRecyclerViewAdapter.submitList(
            listOf(
                DreamModel(
                    0,
                    "Chcę dostać",
                    "Różowy laptop",
                    "Gosia",
                    8,
                    "Warszawa",
                    10,
                    testImageUrl
                )
            )
        )
        doneDreamsRecyclerViewAdapter.submitList(
            listOf(
                DreamModel(
                    1,
                    "Chcę dostać",
                    "Różowy laptop",
                    "Gosia",
                    8,
                    "Waszawa",
                    100,
                    testImageUrl
                )
            )
        )
    }

    private fun setupRecyclersAdapters() {
        doneDreamsRecyclerViewAdapter = DreamsRecyclerViewAdapter()
        with(binding.doneDreamsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = doneDreamsRecyclerViewAdapter
        }
        activeDreamsRecyclerViewAdapter = DreamsRecyclerViewAdapter()
        with(binding.activeDreamsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = activeDreamsRecyclerViewAdapter
        }
    }
}