package com.example.alpaki.presentation.desktop.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.databinding.ItemDesktopCategoryBinding
import com.example.alpaki.presentation.desktop.adapters.DesktopCategoriesAdapter.DreamCategoryViewHolder
import com.example.domain.models.DreamCategory

class DesktopCategoriesAdapter(
    private val onItemClick: (DreamCategory) -> Unit
) : ListAdapter<DreamCategory, DreamCategoryViewHolder>(ItemCallback) {

    companion object {
        private val ItemCallback = object : DiffUtil.ItemCallback<DreamCategory>() {
            override fun areItemsTheSame(oldItem: DreamCategory, newItem: DreamCategory): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DreamCategory,
                newItem: DreamCategory
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesktopCategoryBinding.inflate(inflater, parent, false)
        return DreamCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DreamCategoryViewHolder, position: Int) {
//        holder.bind(categories[position])
    }

    inner class DreamCategoryViewHolder(
        private val binding: ItemDesktopCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val resources: Resources
            get() = binding.root.context.resources

        fun bind(item: DreamCategory) {
        }
    }
}