package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ResetPassword

class ResetPasswordViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val resetPassword: ResetPassword
) : ViewModel() {

    val email = MutableLiveData<String>()

    fun resetPassword() =
        resetPassword(
            viewModelScope,
            ResetPassword.Params(email.value.toString()),
            { result ->
                // Add logic after connecting to backend
            },
            { error ->
                // Add logic after connecting to backend
            }
        )
}
