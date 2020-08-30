package com.example.alpaki.presentation.dreams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.databinding.ItemDreamCardViewBinding
import com.example.alpaki.presentation.myProfile.MyDiffUtil
import com.example.data.api.models.DreamModel

class DreamsViewAdapter(
    private val onItemClick: (DreamModel) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listDiffer: AsyncListDiffer<DreamModel> =
        AsyncListDiffer(
            this,
            MyDiffUtil.TASK_DIFF_UTIL
        )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val binding: ItemDreamCardViewBinding =
            ItemDreamCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DreamsViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DreamsViewHolder).bind(listDiffer.currentList[position])
    }

    override fun getItemCount() = listDiffer.currentList.size

    fun submitList(newList: List<DreamModel>?) {
        listDiffer.submitList(newList)
    }

    inner class DreamsViewHolder(private val binding: ItemDreamCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dreamModel: DreamModel) {
            binding.item = dreamModel
            binding.root.setOnClickListener { onItemClick(dreamModel) }
        }
    }
}
