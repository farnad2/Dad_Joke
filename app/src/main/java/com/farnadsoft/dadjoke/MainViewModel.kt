package com.farnadsoft.dadjoke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farnadsoft.dadjoke.database.JokeEntity
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val repository: Repository): ViewModel() {

    val error:MutableLiveData<String> by lazy {MutableLiveData<String>()}
    private var disposable: Disposable? = null
    var joke=MutableLiveData<JokeData>(JokeData("value","joke",0))

    fun getAJoke(): LiveData<JokeData> {
        repository.getAJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<JokeData> {
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onSuccess(j: JokeData) {
                    joke.value=j
                }

                override fun onError(e: Throwable) {
                    error.postValue("Error on downloading a joke. Check network connection...")
                }

            })
        return joke
    }

    fun getError(): LiveData<String> {
        return error
    }

    fun getJokesFromDB():LiveData<List<JokeEntity>>{
        return repository.getJokes()
    }

    fun putAJokeToDB(joke: JokeEntity) {
        repository.putAJokeToDB(joke)
    }

    fun delete(joke:JokeEntity){
        repository.delete(joke)
    }

    override fun onCleared() {
        disposable!!.dispose()
        super.onCleared()
    }


}