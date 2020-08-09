package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.domain.usecases.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProfileViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val loginUseCase: LoginUseCase
) : ViewModel(), LifecycleObserver {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun logIn() {
        loginUseCase(
            CoroutineScope(Dispatchers.IO),
            LoginUseCase.Params(email.value.toString(), password.value.toString()),
            { result ->
                // Add logic after connecting to backend
            },
            { error ->
                // Add logic after connecting to backend
            }
        )
    }
}
