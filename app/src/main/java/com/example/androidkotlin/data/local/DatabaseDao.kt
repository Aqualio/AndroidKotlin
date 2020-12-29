package com.example.androidkotlin.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidkotlin.data.local.models.UserLocal


@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userLocal")
    fun get(): List<UserLocal>

    @Query("SELECT * FROM userLocal WHERE (email LIKE :email AND password LIKE :password) LIMIT 1") // FIND QUERY TO GET PASSWORD
    fun findByName(email: String, password: String): UserLocal?

    @Insert
    fun insert(user: UserLocal)

 /*   @Delete
    fun delete(user: UserLocal)*/
}

