/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.data.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.mya.bookdbcodetest.data.database.dao.FavoriteDao
import com.mya.bookdbcodetest.data.database.dao.UserDao
import com.mya.bookdbcodetest.model.Book
import com.mya.bookdbcodetest.model.User


@Database(
    entities = [User::class, Book::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun favoriteDao(): FavoriteDao


}

