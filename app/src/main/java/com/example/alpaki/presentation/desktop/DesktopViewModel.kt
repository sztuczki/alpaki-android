@file:Suppress("UsePropertyAccessSyntax")

package com.example.alpaki.presentation.desktop

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.alpaki.core.livedata.wrappers.State
import com.example.domain.models.DreamCategory
import com.example.domain.models.Dreamer
import com.example.domain.usecases.GetCategories
import com.example.domain.usecases.base.GetDreamers
import com.example.domain.usecases.base.None

class DesktopViewModel @ViewModelInject constructor(
    private val getCategories: GetCategories,
    private val getDreamers: GetDreamers
) : ViewModel() {

    private val _dreamers = MutableLiveData<State<List<Dreamer>>>()
    val dreamers: LiveData<State<List<Dreamer>>> = _dreamers

    private val _isLoading = MediatorLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    init {
        _isLoading.addSource(dreamers) { _isLoading.value = it is State.Loading }
    }

    fun getCategories() = getCategories(
        viewModelScope, None,
        ::onGetCategoriesSuccess,
        ::onGetCategoriesError
    )

    private fun onGetCategoriesSuccess(categories: List<DreamCategory>) {
    }

    private fun onGetCategoriesError(throwable: Throwable) {
    }

    fun getDreamers() = getDreamers(
        viewModelScope, GetDreamers.Params(page = 1),
        ::onGetDreamersSuccess,
        ::onGetDreamersError
    )

    private fun onGetDreamersSuccess(dreamers: List<Dreamer>) {
        _dreamers.setValue(State.Success(dreamers))
    }

    private fun onGetDreamersError(throwable: Throwable) {
        _error.setValue(State.Error(throwable))
    }
}