/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mya.bookdbcodetest.data.Repository
import com.mya.bookdbcodetest.model.Book
import com.mya.bookdbcodetest.model.SearchResponse
import com.mya.bookdbcodetest.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var books: MutableLiveData<NetworkResult<SearchResponse>?> = MutableLiveData()

    fun getBooks(category: String) = viewModelScope.launch {
        getBooksSafeCall(category)
    }

    fun insertToFavorite(favorite: Book) = viewModelScope.launch {
        repository.local.insertFavorite(favorite)
    }

    private suspend fun getBooksSafeCall(category: String) {
        books.value = NetworkResult.Loading()

        try {
            val response = repository.remote.searchBooks(category)
            if (response.isSuccessful) {

                books.value = NetworkResult.Success(response.body())
            } else {
                books.value = NetworkResult.Error("No Internet Connection")
            }
        } catch (
            e: Exception
        ) {
            books.value = NetworkResult.Error("${e.message}")

        }
    }
}

