package com.example.alpaki.presentation.desktop

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DreamCategory
import com.example.domain.usecases.GetCategories
import com.example.domain.usecases.base.None

class DesktopViewModel @ViewModelInject constructor(
    private val getCategories: GetCategories
) : ViewModel() {

    fun getCategories() = getCategories(
        viewModelScope, None,
        ::onGetCategoriesSuccess,
        ::onGetCategoriesError
    )

    private fun onGetCategoriesSuccess(categories: List<DreamCategory>) {
        // Pass to LiveData and to DreamCategoriesAdapter
        Log.d("category", "categories -> $categories")
    }

    private fun onGetCategoriesError(throwable: Throwable): Unit {
    }
}