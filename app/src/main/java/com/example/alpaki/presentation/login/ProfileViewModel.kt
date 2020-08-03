package com.example.alpaki.presentation.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.data.repository.TokenRepository

class ProfileViewModel @ViewModelInject constructor(
    private val tokenRepository: TokenRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

}
