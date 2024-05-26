/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mya.bookdbcodetest.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun findByUsername(username: String): User?

    @Query("DELETE FROM users")
    suspend fun deleteUser()
}