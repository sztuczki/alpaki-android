package com.example.alpaki.presentation.desktop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.databinding.ItemDesktopLatestBinding
import com.example.alpaki.presentation.desktop.adapters.DesktopLatestAdapter.LatestDreamViewHolder
import com.example.domain.models.Dreamer

class DesktopLatestAdapter() : ListAdapter<Dreamer, LatestDreamViewHolder>(ItemCallback) {

    companion object {
        private val ItemCallback = object : DiffUtil.ItemCallback<Dreamer>() {

            override fun areItemsTheSame(oldItem: Dreamer, newItem: Dreamer): Boolean {
                return oldItem.dreamId == newItem.dreamId
            }

            override fun areContentsTheSame(oldItem: Dreamer, newItem: Dreamer): Boolean {
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

        fun bind(dreamer: Dreamer) {
            binding.dreamer = dreamer
            val formattedName: String = StringBuilder().run {
                append(dreamer.fullName)
                if (dreamer.fullName.isNotEmpty()) append(" ")
                append("(${dreamer.age} l.)")
                toString()
            }
            binding.textItemDesktopLatestDreamer.text = formattedName
        }
    }
}