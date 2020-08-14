package com.example.alpaki.presentation.fragments

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserCandidate
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
    val activationCode = MutableLiveData<String>()

    private fun createUserCandidate() = UserCandidate(
        name = name.value.orEmpty(),
        surname = surname.value.orEmpty(),
        phone = phone.value.orEmpty(),
        email = email.value.orEmpty(),
        password = password.value.orEmpty(),
        activationCode = activationCode.value.orEmpty()
    )

    fun register() {
        register(
            viewModelScope,
            Register.Params(createUserCandidate()),
            onFailure = {
                //error message
            }
        )
    }
}