package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.data.usecases.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProfileViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val loginUseCase: LoginUseCase
) : ViewModel(), LifecycleObserver {

    fun logIn(email: String, password: String) =
        loginUseCase(
            CoroutineScope(Dispatchers.IO),
            LoginUseCase.Params(email, password),
            { result ->
                // handle success
            },
            { error ->
                // handle error
            }
        )

}
