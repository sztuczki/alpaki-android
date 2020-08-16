package com.example.alpaki.presentation.profile

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.alpaki.core.livedata.wrappers.State
import com.example.domain.usecases.Logout
import com.example.domain.usecases.base.None

class MyProfileViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val logout: Logout
) : ViewModel() {

    private val _success = MediatorLiveData<State<Unit>>()
    val success: LiveData<State<Unit>> = _success

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    fun logOut() {
        logout(
            viewModelScope,
            None,
            ::onLogoutSuccess,
            ::onLogoutError
        )
    }

    private fun onLogoutSuccess(unit: Unit) {
        _success.value = State.Success(unit)
    }

    private fun onLogoutError(throwable: Throwable) {
        _error.value = State.Error(throwable)
    }
}