package com.example.alpaki.presentation.tasks

import android.graphics.Paint
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.data.api.models.TaskModel
import kotlinx.android.synthetic.main.item_task.view.*

class TasksItemAdapter(private val taskList: List<TaskModel>) :
    RecyclerView.Adapter<TasksItemAdapter.TaskItemViewHolder>() {
    inner class TaskItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val taskDescriptionTextVw: AppCompatTextView = itemView.textTaskDescription
        val taskNameTextVw: AppCompatTextView = itemView.textTaskItem
        val isTaskDoneCheckBx: CheckBox = itemView.checkboxTaskItem
        private val showDescriptionImageButton: AppCompatImageButton = itemView.showDescription

        init {
            showDescriptionImageButton.setOnClickListener {
                val hiddenView = itemView.expandableTaskDescriptionView
                if (hiddenView.visibility == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(
                        itemView.taskItem,
                        AutoTransition()
                    );
                    hiddenView.visibility = View.GONE;
                } else {
                    TransitionManager.beginDelayedTransition(
                        itemView.taskItem,
                        AutoTransition()
                    );
                    hiddenView.visibility = View.VISIBLE;
                }
                showDescriptionImageButton.rotateOnClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskNameTextVw.text = task.name
        holder.taskDescriptionTextVw.text = task.description
        holder.isTaskDoneCheckBx.isChecked = task.done
        if (task.done) {
            holder.taskNameTextVw.paintFlags =
                holder.taskNameTextVw.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.taskNameTextVw.paintFlags =
                holder.taskNameTextVw.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}