package com.example.alpaki.presentation.tasks

import android.os.Bundle
import android.view.View
import com.example.alpaki.DreamModel
import com.example.alpaki.R
import com.example.alpaki.core.views.base.BaseFragment
import com.example.alpaki.databinding.ActiveDreamCardViewBinding
import com.example.alpaki.databinding.FragmentTasksBinding
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment : BaseFragment<FragmentTasksBinding>() {
    private val testImageUrl = "https://images.app.goo.gl/GeAiwEuyYp7S3fX49"
    override val layoutId: Int = R.layout.fragment_tasks
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dream = DreamModel(
            0,
            "Chcę dostać",
            "Różowy laptop",
            "Gosia",
            8,
            "Warszawa",
            10,
            testImageUrl
        )
    }
}
