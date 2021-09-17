package com.farnadsoft.dadjoke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.farnadsoft.dadjoke.database.JokeDatabase
import com.farnadsoft.dadjoke.database.JokeEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currentJoke=JokeEntity("0","joke",0)

        val mainViewModel = ViewModelProvider(
            this, MainViewModelFactory(
                Repository(
                    ApiService.create(),
                    JokeDatabase.getInstance(applicationContext)!!.jokeDao()
                )
            )
        )
            .get(MainViewModel::class.java)

        val jokeObserver= Observer<JokeData>{ joke->
            currentJoke=JokeEntity(joke.id,joke.joke,joke.status)
            tv_joke.text=joke.joke
        }
        val errorObserver=Observer<String>{error->tv_joke.text=error}


        fun bringAJoke() {
            mainViewModel.getAJoke().observe(this,jokeObserver)
            mainViewModel.getError().observe(this,errorObserver)
        }

        bringAJoke()

        btn_joke.setOnClickListener {
            bringAJoke()
        }

        btn_add.setOnClickListener {
           mainViewModel.putAJokeToDB(currentJoke)
           Toast.makeText(this,"This joke stored",Toast.LENGTH_SHORT).show()
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

}