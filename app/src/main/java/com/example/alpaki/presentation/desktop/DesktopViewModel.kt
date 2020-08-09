package com.example.alpaki.presentation.desktop

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
    }

    private fun onGetCategoriesError(throwable: Throwable): Unit {
    }
}