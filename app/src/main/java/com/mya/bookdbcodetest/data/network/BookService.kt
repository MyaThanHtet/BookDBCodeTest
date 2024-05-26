package com.mya.bookdbcodetest.data.network


import com.mya.bookdbcodetest.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {
    @GET("search/{query}")
    suspend fun searchBooks(@Path("query") query: String): Response<SearchResponse>
}