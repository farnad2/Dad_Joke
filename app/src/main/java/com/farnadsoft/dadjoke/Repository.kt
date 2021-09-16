package com.farnadsoft.dadjoke

import androidx.lifecycle.LiveData
import com.farnadsoft.dadjoke.database.JokeDao
import com.farnadsoft.dadjoke.database.JokeEntity
import io.reactivex.Completable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

class Repository(private val apiService:RetrofitApiService, private val jokeDao: JokeDao) {

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