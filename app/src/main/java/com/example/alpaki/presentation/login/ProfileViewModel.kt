package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpaki.core.livedata.wrappers.State
import com.example.domain.usecases.Login

class ProfileViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val login: Login
) : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _success = MediatorLiveData<State<Unit>>()
    val success: LiveData<State<Unit>> = _success

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    fun logIn() {
        login(
            viewModelScope,
            Login.Params(email.value.toString(), password.value.toString()),
            ::onLoginSuccess,
            ::onLoginError
        )
    }

    private fun onLoginSuccess(unit: Unit) {
        _success.value = State.Success(unit)
    }

    private fun onLoginError(throwable: Throwable) {
        _error.value = State.Error(throwable)
    }
}
