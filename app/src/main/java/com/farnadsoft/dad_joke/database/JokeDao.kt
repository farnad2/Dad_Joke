package com.farnadsoft.dadjoke0.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JokeDao {
    @Query("SELECT * FROM tbl_jokes")
    fun getJokes(): List<JokeEntity>

    @Insert
    fun insert(joke: JokeEntity)

    @Delete
    fun delete(joke: JokeEntity)
}

