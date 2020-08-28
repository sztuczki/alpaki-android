package com.example.alpaki.presentation.tasks

import android.os.Bundle
import android.view.View
import androidx.core.view.children
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.FragmentTasksBinding
import com.example.data.api.models.TaskModel
import com.example.data.api.models.TasksModel
import com.example.domain.models.Dream
import com.example.domain.models.DreamCategory
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment : BaseFragment<FragmentTasksBinding>() {
    override val layoutId: Int = R.layout.fragment_tasks
    private val tasksViewModel: TasksViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpRecyclerView()
        binding.viewModel = tasksViewModel
    }

    private fun setUpRecyclerView() {
        recyclerView = allTasksWithDreamsRecyclerView
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@TasksFragment.context, RecyclerView.VERTICAL, false)
            adapter = DreamWithTasksAdapter(
                listOf(
                    TasksModel(
                        12,
                        listOf(
                            TaskModel(
                                "Zadanie 1",
                                getString(R.string.example_task_description),
                                true
                            ),
                            TaskModel(
                                "Zadanie 2",
                                getString(R.string.example_task_description),
                                false
                            ),
                            TaskModel(
                                "Zadanie 3",
                                getString(R.string.example_task_description),
                                false
                            ),
                            TaskModel(
                                "Zadanie 4",
                                getString(R.string.example_task_description),
                                false
                            ),
                            TaskModel(
                                "Zadanie 5",
                                getString(R.string.example_task_description),
                                false
                            )
                        )
                    ),
                    TasksModel(
                        12,
                        listOf(
                            TaskModel(
                                "Zadanie 2",
                                getString(R.string.example_task_description),
                                false
                            )
                        )
                    ),
                    TasksModel(
                        12,
                        listOf(
                            TaskModel(
                                "Zadanie 3",
                                getString(R.string.example_task_description),
                                false
                            )
                        )
                    )
                )
                ,
                Dream(
                    123,
                    "Tęczowy Laptop",
                    14,
                    "asdasda",
                    DreamCategory(1231, "asdasdasd"),
                    "asdasd,asdasdas,dasdasd"
                )
            )
        }
    }
}