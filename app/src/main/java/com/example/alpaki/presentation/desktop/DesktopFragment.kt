package com.example.alpaki.presentation.desktop

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentDesktopBinding
import com.example.alpaki.presentation.desktop.adapters.DreamCategoriesAdapter
import com.example.alpaki.presentation.desktop.adapters.SponsorsAdapter
import com.example.domain.models.DreamCategory
import com.example.domain.models.Sponsor
import kotlinx.android.synthetic.main.fragment_desktop.*

class DesktopFragment : BaseFragment<FragmentDesktopBinding>() {

    override val layoutId: Int = R.layout.fragment_desktop

    private val categoriesAdapter: DreamCategoriesAdapter by lazy {
        DreamCategoriesAdapter(::onCategoryItemClick)
    }

    private val sponsorsAdapter: SponsorsAdapter by lazy {
        SponsorsAdapter(::onSponsorItemClick)
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

    private fun onCategoryItemClick(item: DreamCategory) = Unit

    private fun onSponsorItemClick(item: Sponsor) = Unit
}