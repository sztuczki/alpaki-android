package com.example.alpaki.presentation.myProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.api.models.DreamModel
import com.example.alpaki.R
import com.example.alpaki.core.livedata.wrappers.State
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentMyProfileBinding
import com.example.alpaki.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProfileFragment : BaseFragment<FragmentMyProfileBinding>() {

    val testImageUrl =
        "https://i.imgur.com/H357yaH.jpg"
    val testActive = false

    override val layoutId: Int = R.layout.fragment_my_profile
    private val myProfileViewModel: MyProfileViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()

    lateinit var doneDreamsRecyclerViewAdapter: DreamsRecyclerViewAdapter
    lateinit var activeDreamsRecyclerViewAdapter: DreamsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel.checkUser()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tmp = this@MyProfileFragment
            viewModel = myProfileViewModel
        }
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
                    testImageUrl,
                    ""
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
                    testImageUrl,
                    ""
                )
            )
        )
        setupMainViewLiveDataObservers()
        setupViewLiveDataObservers()
    }

    private fun setupViewLiveDataObservers() {
        with(myProfileViewModel) {
            success.observe(viewLifecycleOwner, androidx.lifecycle.Observer { state ->
                if (state is State.Success) {
                    onLogoutSuccess()
                }
            })
        }
    }

    private fun setupMainViewLiveDataObservers() {
        with(mainViewModel) {
            user.observe(viewLifecycleOwner, androidx.lifecycle.Observer { user ->
                if (user is State.Success) {
                    with(binding) {
                        userDetails = user.data
                        invalidateAll()
                    }
                }
            })
        }
    }

    private fun onLogoutSuccess() = findNavController().navigate(R.id.profileFragment)

    private fun setupRecyclersAdapters() {
        doneDreamsRecyclerViewAdapter =
            DreamsRecyclerViewAdapter()
        with(binding.doneDreamsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = doneDreamsRecyclerViewAdapter
        }
        activeDreamsRecyclerViewAdapter =
            DreamsRecyclerViewAdapter()
        with(binding.activeDreamsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = activeDreamsRecyclerViewAdapter
        }
    }

    override fun onDestroyView() {
        with(binding) {
            doneDreamsRecyclerView.adapter = null
            activeDreamsRecyclerView.adapter = null
        }
        super.onDestroyView()
    }
}