package com.example.alpaki.presentation.desktop.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.alpaki.databinding.ItemDesktopCategoryBinding
import com.example.alpaki.presentation.desktop.adapters.DesktopCategoriesAdapter.DreamCategoryViewHolder
import com.example.domain.models.DreamCategory

class DesktopCategoriesAdapter(
    private val onItemClick: (DreamCategory) -> Unit
) : ListAdapter<DreamCategory, DreamCategoryViewHolder>(ItemCallback) {

    companion object {
        private const val CATEGORY_GIFT = 1
        private const val CATEGORY_MEET = 2
        private const val CATEGORY_VISIT = 3
        private const val CATEGORY_BECOME = 4
        private const val CATEGORY_GIVE = 5
        private const val QUICK_MODE = 6


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
        holder.bind(getItem(position))
    }

    inner class DreamCategoryViewHolder(
        private val binding: ItemDesktopCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val resources: Resources
            get() = binding.root.context.resources

        fun bind(item: DreamCategory) {
            binding.textItemDesktopCategory.text = item.dreamCategoryName
            binding.imageItemDesktopCategory.setImageResource(
                when (item.dreamCategoryId.toInt()) {
                    CATEGORY_VISIT -> R.drawable.ic_dream_category_visit_dim_gray
                    CATEGORY_GIFT -> R.drawable.ic_dream_category_gift_dim_gray
                    CATEGORY_MEET -> R.drawable.ic_dream_category_meet_dim_gray
                    CATEGORY_BECOME -> R.drawable.ic_dream_category_become_dim_gray
                    CATEGORY_GIVE -> R.drawable.ic_dream_category_give_dim_gray
                    QUICK_MODE -> R.drawable.ic_dream_category_quick_mode_burnt_sienna
                    else -> R.drawable.ic_dream_category_custom_dim_gray
                }
            )
        }
    }
}