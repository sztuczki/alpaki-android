package com.example.alpaki.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentDesktopBinding
import com.example.alpaki.presentation.adapters.DreamCategoriesAdapter
import com.example.domain.models.DreamCategory
import kotlinx.android.synthetic.main.fragment_desktop.*

class DesktopFragment : BaseFragment<FragmentDesktopBinding>() {

    override val layoutId: Int = R.layout.fragment_desktop

    private val categoriesAdapter: DreamCategoriesAdapter by lazy {
        DreamCategoriesAdapter(::onCategoryItemClick)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        setupCategoriesRecyclerView()
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

    private fun onCategoryItemClick(item: DreamCategory) {}
}