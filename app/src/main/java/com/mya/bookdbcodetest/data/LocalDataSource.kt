package com.mya.bookdbcodetest.data

import com.mya.bookdbcodetest.data.database.dao.FavoriteDao
import com.mya.bookdbcodetest.data.database.dao.UserDao
import com.mya.bookdbcodetest.model.Book
import com.mya.bookdbcodetest.model.User
import javax.inject.Inject

// Local data source responsible for interacting with the AppDatabase
class LocalDataSource @Inject constructor(
    private val userDao: UserDao,
    private val favoriteDao: FavoriteDao
) {

    // Function to fetch a user by username from the database
    suspend fun getLoginUser(): User {
        return userDao.getUser()
    }
    // Function to fetch a user by username from the database
    suspend fun getUser(username: String): User? {
        return userDao.findByUsername(username)
    }

    // Function to insert a user into the database
    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun deleteUser(){
        userDao.deleteUser()
    }

    // Function to fetch all favorites from the database
    suspend fun getAllFavorites(): List<Book> {
        return favoriteDao.getAllFavorites()
    }

    // Function to insert a favorite into the database
    suspend fun insertFavorite(favorite: Book) {
        favoriteDao.insert(favorite)
    }

    // Function to delete a favorite from the database
    suspend fun deleteFavorite(favorite: Book) {
        favoriteDao.delete(favorite)
    }

    suspend fun deleteAllFavorites() {
        favoriteDao.deleteAllFavorites()
    }
}
