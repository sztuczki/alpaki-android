package com.example.alpaki.presentation.desktop.adapters

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.alpaki.databinding.ItemDesktopCategoryBinding
import com.example.alpaki.presentation.desktop.adapters.DreamCategoriesAdapter.DreamCategoryViewHolder
import com.example.domain.models.Category
import com.example.domain.models.Category.*

class DreamCategoriesAdapter(
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<DreamCategoryViewHolder>() {

    private val categories: List<Category> = listOf(
        VISIT,
        GIFT,
        MEET,
        BECOME,
        GIVE,
        QUICK_MODE
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesktopCategoryBinding.inflate(inflater, parent, false)
        return DreamCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: DreamCategoryViewHolder, position: Int) =
        holder.bind(categories[position])

    inner class DreamCategoryViewHolder(
        private val binding: ItemDesktopCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val resources: Resources
            get() = binding.root.context.resources

        fun bind(item: Category) {
            val itemResources = matchResources(item)
            with(binding) {
                textItemDesktopCategory.text = itemResources.first
                imageItemDesktopCategory.setImageDrawable(itemResources.second)
                val labelTextColor: Int =
                    if (item == QUICK_MODE) resources.getColor(R.color.burnt_sienna)
                    else resources.getColor(R.color.dimGray)
                textItemDesktopCategory.setTextColor(labelTextColor)
                root.setOnClickListener { onItemClick(item) }
            }
        }

        private fun matchResources(category: Category): Pair<String, Drawable> {
            val label: String
            val icon: Drawable
            when (category) {
                VISIT -> {
                    label = resources.getString(R.string.text_desktop_category_visit)
                    icon = resources.getDrawable(R.drawable.ic_dream_category_visit_dim_gray, null)
                }
                GIFT -> {
                    label = resources.getString(R.string.text_desktop_category_gift)
                    icon = resources.getDrawable(R.drawable.ic_dream_category_gift_dim_gray, null)
                }
                MEET -> {
                    label = resources.getString(R.string.text_desktop_category_meet)
                    icon = resources.getDrawable(R.drawable.ic_dream_category_meet_dim_gray, null)
                }
                BECOME -> {
                    label = resources.getString(R.string.text_desktop_category_become)
                    icon = resources.getDrawable(R.drawable.ic_dream_category_become_dim_gray, null)
                }
                GIVE -> {
                    label = resources.getString(R.string.text_desktop_category_give)
                    icon = resources.getDrawable(R.drawable.ic_dream_category_give_dim_gray, null)
                }
                QUICK_MODE -> {
                    label = resources.getString(R.string.text_desktop_category_quick_mode)
                    icon = resources.getDrawable(
                        R.drawable.ic_dream_category_quick_mode_burnt_sienna,
                        null
                    )
                }
            }
            return label to icon
        }
    }
}