package com.example.alpaki.presentation.dreams

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.alpaki.R
import com.example.alpaki.core.livedata.wrappers.State
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentDreamsBinding
import com.example.data.api.models.DreamModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_register.*

@AndroidEntryPoint
class DreamsFragment : BaseFragment<FragmentDreamsBinding>() {

    override val layoutId: Int = R.layout.fragment_dreams

    private val viewModel: DreamsViewModel by viewModels()

    lateinit var dreamsAdapter: DreamsViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDreams()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerAdapter()
        setupViewLiveDataObservers()

        with(titleBarView) {
            setLeftIconClickListener { ::filterIconClickAction }
            setRightIconClickListener { ::addNewIconClickAction }
        }
    }

    private fun filterIconClickAction() {
        // TODO Screen with filter
    }

    private fun addNewIconClickAction() {
        // TODO Screen add dream
    }

    private fun onDreamClickAction(dreamModel: DreamModel) {
        // TODO Screen with dream's details
    }

    private fun setupRecyclerAdapter() {
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.divider_horizontal_space_10dp)
                ?.let { setDrawable(it) }
        }
        dreamsAdapter =
            DreamsViewAdapter(::onDreamClickAction)
        with(binding.rvDreamsList) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = dreamsAdapter
            addItemDecoration(decoration)
        }
    }

    private fun setupViewLiveDataObservers() {
        viewModel.dreams.observe(viewLifecycleOwner, Observer { state ->
            if (state is State.Success) {
                dreamsAdapter.submitList(state.data)
            }
        })
    }

    override fun onDestroyView() {
        binding.rvDreamsList.adapter = null
        super.onDestroyView()
    }
}
