package com.example.alpaki.presentation.profile

import androidx.recyclerview.widget.DiffUtil
import com.example.alpaki.DreamModel


internal object MyDiffUtill {
    val TASK_DIFF_UTIL: DiffUtil.ItemCallback<DreamModel> =
        object : DiffUtil.ItemCallback<DreamModel>() {
            override fun areItemsTheSame(
                oldItem: DreamModel,
                newItem: DreamModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DreamModel,
                newItem: DreamModel
            ): Boolean {
                return oldItem == newItem
            }
        }
}