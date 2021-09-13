package com.farnadsoft.dadjoke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.room.Room
import com.farnadsoft.dadjoke.database.JokeDatabase
import com.farnadsoft.dadjoke.database.JokeEntity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val model:MainViewModel by viewModels()

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

        btn_favorite.setOnClickListener {
            val intent:Intent= Intent(this,JokesActivity::class.java)
            startActivity(intent)
        }

        btn_share_joke.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, tv_joke.text.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    private fun bringAJoke ():JokeEntity{
    //private fun bringAJoke (){
        //counter++
        var joke=JokeEntity("0","oops no joke received",0)
        //var joke=JokeData("0","oops no joke received",0)
        val apiService = RetrofitApiService.create().getAJoke()
        apiService.enqueue( object : Callback<JokeData>{
            override fun onResponse(call: Call<JokeData>?, response: Response<JokeData>?) {
                joke= JokeEntity(response?.body()!!.id,response?.body()!!.joke,response?.body()!!.status)
                //tv_joke.text=response?.body()?.joke
                tv_joke.text=joke.joke
            }
            override fun onFailure(call: Call<JokeData>?, t: Throwable?) {
            }
        })
        return joke
    }
}