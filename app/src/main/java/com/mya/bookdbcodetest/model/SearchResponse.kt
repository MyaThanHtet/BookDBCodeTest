/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("total")
    val total: String,

    @SerializedName("books")
    val books: List<Book>
)


