package com.farnadsoft.dadjoke.database

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {
    @Query("SELECT * FROM tbl_jokes")
    fun getJokes(): LiveData<List<JokeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(joke: JokeEntity)

    @Delete
    fun delete(joke: JokeEntity)
}

