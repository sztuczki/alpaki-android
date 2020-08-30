package com.example.alpaki.presentation.myProfile

import androidx.recyclerview.widget.DiffUtil
import com.example.data.api.models.DreamModel

internal object MyDiffUtil {
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