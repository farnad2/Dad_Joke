package com.farnadsoft.dadjoke

import androidx.lifecycle.LiveData
import com.farnadsoft.dadjoke.database.JokeDao
import com.farnadsoft.dadjoke.database.JokeEntity
import io.reactivex.Single

class Repository(private val apiService:ApiService, private val jokeDao: JokeDao) {

    fun getAJoke():Single<JokeData>{
        return apiService.getAJoke()
    }

    fun getJokes(): LiveData<List<JokeEntity>> {return jokeDao.getJokes()}

    fun putAJokeToDB(joke:JokeEntity){
        jokeDao.insert(joke)
    }

    fun delete(joke:JokeEntity){
        jokeDao.delete(joke)
    }
}