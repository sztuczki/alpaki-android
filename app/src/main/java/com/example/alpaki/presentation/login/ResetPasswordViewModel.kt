package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.domain.usecases.Login
import com.example.domain.usecases.ResetPassword
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ResetPasswordViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val resetPassword: ResetPassword
) : ViewModel(), LifecycleObserver {

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
