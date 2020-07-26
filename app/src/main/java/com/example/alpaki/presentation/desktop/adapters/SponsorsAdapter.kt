package com.example.alpaki.presentation.desktop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.databinding.ItemDesktopSponsorBinding
import com.example.domain.models.Sponsor

class SponsorsAdapter(
    private val onItemClick: (Sponsor) -> Unit
) : ListAdapter<Sponsor, SponsorsAdapter.SponsorViewHolder>(ItemCallback) {

    companion object {
        private val ItemCallback = object : DiffUtil.ItemCallback<Sponsor>() {
            override fun areItemsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesktopSponsorBinding.inflate(inflater, parent, false)
        return SponsorViewHolder(binding)
    }


    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SponsorViewHolder(
        private val binding: ItemDesktopSponsorBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Sponsor) {
            binding.sponsor = item
            binding.root.setOnClickListener { onItemClick(item) }
            binding.executePendingBindings()
        }
    }
}