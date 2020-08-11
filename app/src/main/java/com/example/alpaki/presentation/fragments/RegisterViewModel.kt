package com.example.alpaki.presentation.fragments

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.domain.models.UserCandidate
import com.example.domain.usecases.Register
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class RegisterViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val register: Register
) : ViewModel(), LifecycleObserver {

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
            CoroutineScope(Dispatchers.IO),
            Register.Params(createUserCandidate()),
            onFailure = {
                //error message
            }
        )
    }
}