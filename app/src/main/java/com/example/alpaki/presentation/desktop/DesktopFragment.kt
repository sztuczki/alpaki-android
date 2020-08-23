package com.example.alpaki.presentation.desktop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.alpaki.R
import com.example.alpaki.core.livedata.wrappers.State
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentDesktopBinding
import com.example.alpaki.presentation.desktop.adapters.DesktopCategoriesAdapter
import com.example.alpaki.presentation.desktop.adapters.DesktopDreamsAdapter
import com.example.alpaki.presentation.desktop.adapters.DesktopLatestAdapter
import com.example.alpaki.presentation.desktop.adapters.DesktopSponsorsAdapter
import com.example.domain.models.DreamCategory
import com.example.domain.models.Sponsor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_desktop.*

@AndroidEntryPoint
class DesktopFragment : BaseFragment<FragmentDesktopBinding>() {

    override val layoutId: Int = R.layout.fragment_desktop

    private val viewModel: DesktopViewModel by viewModels()

    private val latestAdapter: DesktopLatestAdapter by lazy { DesktopLatestAdapter() }
    private val categoriesAdapter: DesktopCategoriesAdapter by lazy { DesktopCategoriesAdapter(::onCategoryItemClick) }
    private val sponsorsAdapter: DesktopSponsorsAdapter by lazy { DesktopSponsorsAdapter(::onSponsorItemClick) }
    private val dreamsAdapter: DesktopDreamsAdapter by lazy { DesktopDreamsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDreamers()
        viewModel.getCategories()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupViewLiveDataObservers()
    }

    private fun setupView() {
        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        setupLatestRecyclerView()
        setupCategoriesRecyclerView()
        setupSponsorsRecyclerView()
        setupDreamersRecyclerView()
    }

    private fun setupLatestRecyclerView() {
        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).apply {
            setDrawable(resources.getDrawable(R.drawable.divider_horizontal_space_10dp, null))
        }
        rvDesktopLatest.apply {
            adapter = latestAdapter
            addItemDecoration(decoration)
        }
    }

    private fun setupCategoriesRecyclerView() {
        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).apply {
            setDrawable(resources.getDrawable(R.drawable.divider_horizontal_space_10dp, null))
        }
        rvDesktopCategories.apply {
            adapter = categoriesAdapter
            addItemDecoration(decoration)
        }
    }

    private fun setupSponsorsRecyclerView() {
        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).apply {
            setDrawable(resources.getDrawable(R.drawable.divider_horizontal_space_10dp, null))
        }
        rvDesktopSponsors.apply {
            adapter = sponsorsAdapter
            addItemDecoration(decoration)
        }
        sponsorsAdapter.submitList(
            listOf(
                Sponsor(1, null, false),
                Sponsor(2, null, true),
                Sponsor(3, null, false)
            )
        )
    }

    private fun setupDreamersRecyclerView() {
        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).apply {
            setDrawable(resources.getDrawable(R.drawable.divider_horizontal_space_20dp, null))
        }
        rvDesktopDreamers.apply {
            adapter = dreamsAdapter
            addItemDecoration(decoration)
        }
    }

    private fun setupViewLiveDataObservers() {
        viewModel.dreams.observe(viewLifecycleOwner, Observer { state ->
            if (state is State.Success) {
                latestAdapter.submitList(state.data)
                dreamsAdapter.submitList(state.data)
            }
        })
        viewModel.categories.observe(viewLifecycleOwner, Observer { state ->
            if (state is State.Success) categoriesAdapter.submitList(state.data)
        })
    }

    private fun onCategoryItemClick(item: DreamCategory) = Unit

    private fun onSponsorItemClick(item: Sponsor) = Unit

    override fun onDestroyView() {
        rvDesktopLatest.adapter = null
        rvDesktopCategories.adapter = null
        rvDesktopSponsors.adapter = null
        super.onDestroyView()
    }
}