package com.example.alpaki.presentation.desktop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentDesktopBinding
import com.example.alpaki.presentation.desktop.adapters.DreamCategoriesAdapter
import com.example.alpaki.presentation.desktop.adapters.SponsorsAdapter
import com.example.domain.models.Category
import com.example.domain.models.Sponsor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_desktop.*

@AndroidEntryPoint
class DesktopFragment : BaseFragment<FragmentDesktopBinding>() {

    override val layoutId: Int = R.layout.fragment_desktop

    private val viewModel: DesktopViewModel by viewModels()

    private val categoriesAdapter: DreamCategoriesAdapter by lazy { DreamCategoriesAdapter(::onCategoryItemClick) }
    private val sponsorsAdapter: SponsorsAdapter by lazy { SponsorsAdapter(::onSponsorItemClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDreamers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        setupCategoriesRecyclerView()
        setupSponsorsRecyclerView()
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

    private fun onCategoryItemClick(item: Category) = Unit

    private fun onSponsorItemClick(item: Sponsor) = Unit
}