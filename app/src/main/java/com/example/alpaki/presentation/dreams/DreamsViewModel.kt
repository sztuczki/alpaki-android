package com.example.alpaki.presentation.dreams

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpaki.core.livedata.wrappers.State
import com.example.data.api.models.DreamModel
import com.example.data.mappers.toDreamModel
import com.example.domain.models.Dream
import com.example.domain.usecases.GetDreams

class DreamsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getDreams: GetDreams
) : ViewModel() {

    private val _dreams = MutableLiveData<State<List<DreamModel>>>()
    val dreams: LiveData<State<List<DreamModel>>> = _dreams

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    fun getDreams() = getDreams(
        viewModelScope, GetDreams.Params(page = 1),
        ::onGetDreamsSuccess,
        ::onGetDreamsError
    )

    private fun onGetDreamsSuccess(dreams: List<Dream>) {
        _dreams.value = State.Success(dreams.map(Dream::toDreamModel))
    }

    private fun onGetDreamsError(throwable: Throwable) {
        _error.value = State.Error(throwable)
    }
}