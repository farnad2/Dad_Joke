package com.farnadsoft.dadjoke.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface JokeDao {
    @Query("SELECT * FROM tbl_jokes")
    fun getJokes(): List<JokeEntity>
    //fun getJokes(): LiveData<List<JokeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(joke: JokeEntity)

    @Delete
    fun delete(joke: JokeEntity)
}

