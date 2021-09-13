package com.farnadsoft.dadjoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.farnadsoft.dadjoke0.JokeData
import com.farnadsoft.dadjoke0.RetrofitApiService
import com.farnadsoft.dadjoke0.database.JokeDatabase
import com.farnadsoft.dadjoke0.database.JokeEntity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //var counter=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            JokeDatabase::class.java, "joke_database.db"
        )
            .allowMainThreadQueries()
            .build()

        val jokeDao = db.jokeDao()

        var joke=bringAJoke()

//        for (i in 1..1) {
//            joke = JokeEntity("3", "joke$i", i)
//            jokeDao.insert(joke)
//        }

        btn_joke.setOnClickListener {
            joke=bringAJoke()
        }

        btn_add.setOnClickListener {
            //val jokeEntity=JokeEntity(counter.toString(),tv_joke.text.toString(),0)
            //counter++
            jokeDao.insert(joke)
        }

    }

    private fun bringAJoke ():JokeEntity{
    //private fun bringAJoke (){
        //counter++
        var joke=JokeEntity("0","oops no joke received",0)
        val apiService = RetrofitApiService.create().getJokes()
        apiService.enqueue( object : Callback<JokeData>{
            override fun onResponse(call: Call<JokeData>?, response: Response<JokeData>?) {
                joke= JokeEntity(response?.body()!!.id, response.body()!!.joke, response.body()!!.status)
                //tv_joke.text=response?.body()?.joke
                tv_joke.text=joke.joke
            }
            override fun onFailure(call: Call<JokeData>?, t: Throwable?) {
            }
        })
        return joke
    }
}