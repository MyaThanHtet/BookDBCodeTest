package com.mya.bookdbcodetest.data

import com.mya.bookdbcodetest.data.network.BookService
import com.mya.bookdbcodetest.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

// Remote data source responsible for interacting with the remote API
class RemoteDataSource @Inject constructor(
    private val bookService: BookService
) {

    // Function to search books remotely
    suspend fun searchBooks(query: String): Response<SearchResponse>  {
        return bookService.searchBooks(query)
    }
}
