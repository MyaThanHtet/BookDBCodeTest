/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.register


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mya.bookdbcodetest.data.LocalDataSource
import com.mya.bookdbcodetest.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val localDataSource: LocalDataSource) : ViewModel() {

    private val _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean>
        get() = _registrationStatus

    fun registerUser(username: String, password: String) {
        viewModelScope.launch {
            val existingUser = localDataSource.getUser(username)
            if (existingUser == null) {
                val user = User(username = username, password = password)
                localDataSource.insertUser(user)
                _registrationStatus.value = true
            } else {
                _registrationStatus.value = false
            }
        }
    }
}
