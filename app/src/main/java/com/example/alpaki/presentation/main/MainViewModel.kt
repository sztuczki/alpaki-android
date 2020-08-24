package com.example.alpaki.presentation.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpaki.core.livedata.wrappers.State
import com.example.data.api.models.UserRoleEnum
import com.example.domain.models.UserDetails
import com.example.domain.usecases.GetMyInformation
import com.example.domain.usecases.IsLoggedIn
import com.example.domain.usecases.base.None

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getMyInformation: GetMyInformation,
    private val isLoggedIn: IsLoggedIn
) : ViewModel() {

    private val _role = MediatorLiveData<State<UserRoleEnum>>()
    val role: LiveData<State<UserRoleEnum>> = _role

    private val _user = MediatorLiveData<State<UserDetails>>()
    val user: LiveData<State<UserDetails>> = _user

    private val _loggedIn = MediatorLiveData<State<Boolean>>()
    val loggedIn: LiveData<State<Boolean>> = _loggedIn

    fun checkRole() {
        getMyInformation(
            viewModelScope,
            None,
            ::onCheckRoleSuccess,
            ::onCheckRoleError
        )
    }

    fun checkUser() {
        getMyInformation(
            viewModelScope,
            None,
            ::onUserSuccess,
            ::onUserError
        )
    }

    fun isLoggedIn() {
        isLoggedIn(
            viewModelScope,
            None,
            ::isLoggedInSuccess,
            ::isLoggedInError
        )
    }

    private fun onCheckRoleSuccess(user: UserDetails) {
        _role.value = when (user.userRole) {
            1L -> State.Success(UserRoleEnum.VOLUNTEER)
            3L -> State.Success(UserRoleEnum.SUPERVISOR)
            7L -> State.Success(UserRoleEnum.ADMIN)
            else -> State.Success(UserRoleEnum.NONE)
        }
    }

    private fun onCheckRoleError(throwable: Throwable) {
        _role.value = State.Error(throwable)
    }

    private fun isLoggedInError(throwable: Throwable) {
        _loggedIn.value = State.Error(throwable)
    }

    private fun onUserError(throwable: Throwable) {
        _user.value = State.Error(throwable)
    }

    private fun isLoggedInSuccess(isLoggedIn: Boolean) {
        _loggedIn.value = State.Success(isLoggedIn)
    }

    private fun onUserSuccess(user: UserDetails) {
        _user.value = State.Success(user)
    }
}