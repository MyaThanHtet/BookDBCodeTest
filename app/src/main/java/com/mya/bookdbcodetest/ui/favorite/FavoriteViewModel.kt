/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mya.bookdbcodetest.data.Repository
import com.mya.bookdbcodetest.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var favorites: MutableLiveData<List<Book?>> = MutableLiveData()
    fun getFavorites() = viewModelScope.launch {
        getFavoritesSafeCall()
    }

    fun removeFavorite(favorite: Book) = viewModelScope.launch {
        repository.local.deleteFavorite(favorite)
        getFavoritesSafeCall()
    }

    private suspend fun getFavoritesSafeCall() {

        try {
            val response = repository.local.getAllFavorites()
            favorites.value = response
        } catch (
            _: Exception
        ) {
        }
    }

}