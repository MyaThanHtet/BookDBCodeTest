/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mya.bookdbcodetest.data.Repository
import com.mya.bookdbcodetest.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var user: MutableLiveData<User?> = MutableLiveData()

    fun getUser() = viewModelScope.launch {
        try {
            val response = repository.local.getLoginUser()
            user.value = response
        } catch (
            _: Exception
        ) {
        }
    }

    fun logOut()= viewModelScope.launch {
        repository.local.deleteUser()
    }
}