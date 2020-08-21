package com.example.alpaki.presentation.register

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpaki.core.livedata.wrappers.State
import com.example.domain.usecases.Register

class RegisterViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val register: Register
) : ViewModel() {

    val name = MutableLiveData<String>()
    val surname = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val brand = MutableLiveData<String>()

    private val _success = MediatorLiveData<State<Unit>>()
    val success: LiveData<State<Unit>> = _success

    private val _error = MutableLiveData<State<Throwable>>()
    val error: LiveData<State<Throwable>> = _error

    fun register() {
        register(
            viewModelScope,
            Register.Params( firstName = name.value.orEmpty(),
                lastName = surname.value.orEmpty(),
                phoneNumber = phone.value.orEmpty(),
                email = email.value.orEmpty(),
                password = password.value.orEmpty(),
                code = code.value.orEmpty(),
                brand = brand.value.orEmpty()),
            ::onRegisterSuccess,
            ::onRegisterError
        )
    }

    private fun onRegisterSuccess(unit: Unit) {
        _success.value = State.Success(unit)
    }

    private fun onRegisterError(throwable: Throwable) {
        _error.value = State.Error(throwable)
    }
}