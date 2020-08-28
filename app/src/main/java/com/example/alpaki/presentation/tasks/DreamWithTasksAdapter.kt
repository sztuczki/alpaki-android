package com.example.alpaki.presentation.tasks

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.data.api.models.TasksModel
import com.example.domain.models.Dream
import kotlinx.android.synthetic.main.group_item_task.view.*


class DreamWithTasksAdapter(
    private val tasksWithDreamList: List<TasksModel>,
    private val dream: Dream
) : RecyclerView.Adapter<DreamWithTasksAdapter.DreamWithTaskViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    inner class DreamWithTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskItemRecyclerView: RecyclerView = itemView.taskItemsRecyclerView
        val dreamerInfoTextView: AppCompatTextView = itemView.dreamerInfo
        val percentageTextView: AppCompatTextView = itemView.taskPercentage
        val dreamInfo: AppCompatTextView = itemView.dreamName
        private val showMore: ImageButton = itemView.showAllTasks
        private val showDreamButton: AppCompatButton = itemView.showDreamButton
        private val showAllDescriptions: ImageButton = itemView.showAllDescriptions

        init {
            showMore.setOnClickListener {
                val hiddenView = itemView.showTasks
                if (hiddenView.visibility == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(
                        itemView.baseCardView,
                        AutoTransition()
                    );
                    hiddenView.visibility = View.GONE;
                } else {
                    TransitionManager.beginDelayedTransition(
                        itemView.baseCardView,
                        AutoTransition()
                    );
                    hiddenView.visibility = View.VISIBLE;
                }
                showMore.rotateOnClick()
            }

            showDreamButton.setOnClickListener {

            }

            showAllDescriptions.setOnClickListener {

                showAllDescriptions.rotateOnClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamWithTaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.group_item_task, parent, false)
        return DreamWithTaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasksWithDreamList.size
    }

    override fun onBindViewHolder(holder: DreamWithTaskViewHolder, position: Int) {
        val task = tasksWithDreamList[position]
        val childLayoutManager =
            LinearLayoutManager(holder.taskItemRecyclerView.context, RecyclerView.VERTICAL, false)
        holder.percentageTextView.text = "8%"
        holder.dreamInfo.text = dream.displayName
        holder.dreamerInfoTextView.text = "Mateusz / ${dream.age} / lokalizacja"
        holder.taskItemRecyclerView.apply {
            layoutManager = childLayoutManager
            adapter = TasksItemAdapter(task.tasks)
            setRecycledViewPool(viewPool)
        }
    }
}