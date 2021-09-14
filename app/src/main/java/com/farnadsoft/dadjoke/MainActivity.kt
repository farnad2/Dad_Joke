package com.farnadsoft.dadjoke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.farnadsoft.dadjoke.database.JokeDatabase
import com.farnadsoft.dadjoke.database.JokeEntity
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var currentJoke=JokeEntity("0","joke",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(
            this, MainViewModelFactory(
                Repository(
                    ApiServiceProvider.getApiService(),
                    JokeDatabase.getInstance(applicationContext)!!.jokeDao()
                )
            )
        )
            .get(MainViewModel::class.java)

        val jokeObserver= Observer<JokeData>{ joke->
            currentJoke.id=joke.id
            currentJoke.joke=joke.joke
            currentJoke.status=joke.status
            tv_joke.text=joke.joke
        }
        val error=Observer<String>{error->Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()}

        val db = Room.databaseBuilder(
            applicationContext,
            JokeDatabase::class.java, "joke_database.db"
        )
            .allowMainThreadQueries()
            .build()

        val jokeDao = db.jokeDao()


        fun bringAJoke() {
            mainViewModel.getAJoke().observe(this,jokeObserver)
            mainViewModel.getError().observe(this,error)
        }

        bringAJoke()

        fun storeJoke(joke:JokeEntity){
            jokeDao.insert(joke)
        }

        btn_joke.setOnClickListener {
            bringAJoke()
        }

        btn_add.setOnClickListener {
           storeJoke(currentJoke)
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