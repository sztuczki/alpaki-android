package com.example.alpaki.presentation.desktop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.alpaki.databinding.ItemDesktopPersonBinding
import com.example.domain.models.Dreamer

class DesktopDreamersAdapter
    : ListAdapter<Dreamer, DesktopDreamersAdapter.DreamerViewHolder>(ITEM_CALLBACK) {

    companion object {
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Dreamer>() {

            override fun areItemsTheSame(oldItem: Dreamer, newItem: Dreamer): Boolean {
                return oldItem.dreamId == newItem.dreamId
            }

            override fun areContentsTheSame(oldItem: Dreamer, newItem: Dreamer): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesktopPersonBinding.inflate(inflater, parent, false)
        return DreamerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DreamerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DreamerViewHolder(
        private val binding: ItemDesktopPersonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Dreamer) {
            with(binding) {
                imageItemDesktopPerson.setImageResource(R.drawable.ic_item_dreamer_placeholder_80dp)
                textItemDesktopPersonName.text = item.fullName
                textItemDesktopPersonCity.text = "Placeholder city"
            }
        }
    }
}