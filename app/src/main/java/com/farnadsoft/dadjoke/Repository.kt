package com.farnadsoft.dadjoke

import androidx.lifecycle.LiveData
import com.farnadsoft.dadjoke.database.JokeDao
import com.farnadsoft.dadjoke.database.JokeEntity
import io.reactivex.Completable
import io.reactivex.Single

class Repository(private val apiService:RetrofitApiService, private val jokeDao: JokeDao) {

//    fun getAJoke():Single<JokeData>{
//        //return apiService.getAJoke().doOnSuccess(joke->jokeDao.insert(joke)).ignoreElement()
//        return apiService.getAJoke()
//
//    }
//
//    fun getJokes(): LiveData<List<JokeEntity>> {return jokeDao.getJokes()}
}