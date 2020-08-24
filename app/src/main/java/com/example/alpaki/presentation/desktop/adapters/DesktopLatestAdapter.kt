package com.example.alpaki.presentation.desktop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.databinding.ItemDesktopLatestBinding
import com.example.alpaki.presentation.desktop.adapters.DesktopLatestAdapter.LatestDreamViewHolder
import com.example.domain.models.Dream

class DesktopLatestAdapter() : ListAdapter<Dream, LatestDreamViewHolder>(ItemCallback) {

    companion object {
        private val ItemCallback = object : DiffUtil.ItemCallback<Dream>() {

            override fun areItemsTheSame(oldItem: Dream, newItem: Dream): Boolean {
                return oldItem.dreamId == newItem.dreamId
            }

            override fun areContentsTheSame(oldItem: Dream, newItem: Dream): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestDreamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesktopLatestBinding.inflate(inflater, parent, false)
        return LatestDreamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestDreamViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LatestDreamViewHolder(
        private val binding: ItemDesktopLatestBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dream: Dream) {
            binding.dream = dream
            val formattedName: String = StringBuilder().run {
                if (dream.displayName?.isNotEmpty() == true) {
                    append(dream.displayName)
                    append(" ")
                }
                append("(${dream.age} l.)")
                toString()
            }
            binding.textItemDesktopLatestName.text = formattedName
        }
    }
}