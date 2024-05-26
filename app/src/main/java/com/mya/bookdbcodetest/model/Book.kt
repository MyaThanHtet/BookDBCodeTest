/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "book")
data class Book(
    @SerializedName("id")
    val identity: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String?,

    @SerializedName("authors")
    val authors: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("url")
    val url: String,

    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean

) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var idBook: Int = 0


}