/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.data.database.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mya.bookdbcodetest.model.Book

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insert(favorite: Book)

    @Delete
    suspend fun delete(favorite: Book)

    @Query("SELECT * FROM book")
    suspend fun getAllFavorites(): List<Book>

    @Query("DELETE FROM book")
    suspend fun deleteAllFavorites()
}
