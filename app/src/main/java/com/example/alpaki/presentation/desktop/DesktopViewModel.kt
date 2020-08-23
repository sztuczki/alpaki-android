@file:Suppress("UsePropertyAccessSyntax")

package com.example.alpaki.presentation.desktop

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpaki.core.livedata.wrappers.State
import com.example.domain.models.Dream
import com.example.domain.models.DreamCategory
import com.example.domain.usecases.GetCategories
import com.example.domain.usecases.GetDreams
import com.example.domain.usecases.base.None

class DesktopViewModel @ViewModelInject constructor(
    private val getCategories: GetCategories,
    private val getDreams: GetDreams
) : ViewModel() {

    private val _dreams = MutableLiveData<State<List<Dream>>>()
    val dreams: LiveData<State<List<Dream>>> = _dreams

    private val _categories = MutableLiveData<State<List<DreamCategory>>>()
    val categories: LiveData<State<List<DreamCategory>>> = _categories

    private val _isLoading = MediatorLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    init {
        _isLoading.addSource(dreams) { _isLoading.value = it is State.Loading }
    }

    fun getCategories() = getCategories(
        viewModelScope, None,
        ::onGetCategoriesSuccess,
        ::onGetCategoriesError
    )

    private fun onGetCategoriesSuccess(categories: List<DreamCategory>) {
        _categories.value = State.Success(categories)
    }

    private fun onGetCategoriesError(throwable: Throwable) {
    }

    fun getDreams() = getDreams(
        viewModelScope, GetDreams.Params(page = 1),
        ::onGetDreamsSuccess,
        ::onGetDreamsError
    )

    private fun onGetDreamsSuccess(dreams: List<Dream>) {
        _dreams.setValue(State.Success(dreams))
    }

    private fun onGetDreamsError(throwable: Throwable) {
        _error.setValue(State.Error(throwable))
    }
}