package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.Login

class ProfileViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val login: Login
) : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun logIn() {
        login(
            viewModelScope,
            Login.Params(email.value.toString(), password.value.toString()),
            { result ->
                // Add logic after connecting to backend
            },
            { error ->
                // Add logic after connecting to backend
            }
        )
    }
}
