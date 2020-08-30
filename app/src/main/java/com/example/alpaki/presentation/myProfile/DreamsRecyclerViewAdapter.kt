package com.example.alpaki.presentation.myProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.data.api.models.DreamModel
import com.example.alpaki.databinding.ActiveDreamCardViewBinding
import com.example.alpaki.databinding.DoneDreamCardViewBinding

enum class DreamViewType(val viewType: Int) {
    DONE_DREAM(0),
    ACTIVE_DREAM(1)
}

class DreamsRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listDiffer: AsyncListDiffer<DreamModel> =
        AsyncListDiffer<DreamModel>(this,
            MyDiffUtil.TASK_DIFF_UTIL
        )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == DreamViewType.ACTIVE_DREAM.viewType) {
            val binding: ActiveDreamCardViewBinding =
                ActiveDreamCardViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            ActiveDreamsViewHolder(
                binding
            )
        } else {
            val binding: DoneDreamCardViewBinding =
                DoneDreamCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            DoneDreamsViewHolder(
                binding
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (listDiffer.currentList[position].dreamPercent == 100) {
            DreamViewType.DONE_DREAM.viewType
        } else {
            DreamViewType.ACTIVE_DREAM.viewType
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DreamViewType.ACTIVE_DREAM.viewType) {
            (holder as ActiveDreamsViewHolder).bind(listDiffer.currentList[position])
        } else {
            (holder as DoneDreamsViewHolder).bind(listDiffer.currentList[position])
        }
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun submitList(newList: List<DreamModel>?) {
        listDiffer.submitList(newList)
    }
}

class ActiveDreamsViewHolder(private val biding: ActiveDreamCardViewBinding) :
    RecyclerView.ViewHolder(biding.root) {
    fun bind(dreamModel: DreamModel) {
        biding.item = dreamModel
        biding.activeDreamDreamProgress.setOnTouchListener { _, _ -> true }
    }
}

class DoneDreamsViewHolder(private val biding: DoneDreamCardViewBinding) :
    RecyclerView.ViewHolder(biding.root) {
    fun bind(dreamModel: DreamModel) {
        biding.item = dreamModel
    }
}